package LLD_Codes;

import java.util.*;
import java.util.stream.Collectors;

enum VehicleType {
	CAR,
	BIKE,
	TRUCK,
	VAN,
	SUV
}


enum VehicleStatus {
	RENTED,
	AVAILABLE,
	IN_MAINTENANCE
}


enum RideStatus {
	IN_PROGRESS,
	RETURNED,
	CANCELLED
}


enum PaymentStatus {
	PAID,
	FAILED,
	IN_PROGRESS
}


enum PaymentMode {
	CC,
	DC,
	UPI,
	CASH
}


public class VehicleRentalSystem {

	static Search searchObj = new Search();

	static Map<String, Vehicle> vehicleMap = new HashMap<>();
	static Map<Integer, BookingInfo> bookingInfoMap = new HashMap<>();
	static BookingService bookingService = new BookingService();
	static VehicleService vehicleService = new VehicleService();

	public static void main(String[] args) {
		Admin admin = new Admin("admin@gmail.com");
		// LLD_Codes.Admin add api test
		Vehicle vehicle1 = admin.addVehicle(new Vehicle("1", 1, VehicleType.CAR, VehicleStatus.AVAILABLE, 100), vehicleMap);
		Vehicle vehicle2 = admin.addVehicle(new Vehicle("2", 2, VehicleType.BIKE, VehicleStatus.AVAILABLE, 50), vehicleMap);
		Vehicle vehicle3 = admin.addVehicle(new Vehicle("3", 3, VehicleType.SUV, VehicleStatus.AVAILABLE, 120), vehicleMap);

		System.out.println("LLD_Codes.Vehicle DB after adding all vehicles: " + vehicleMap);
		// LLD_Codes.Admin remove api test
		admin.removeVehicle(vehicle2.getBarCode(), vehicleMap);

		System.out.println("LLD_Codes.Vehicle DB after removing vehicle 2: " + vehicleMap);

		RegisteredUser registeredUser = new RegisteredUser("nikhil1303kumar@gmail.com");

		// Make booking API
		BookingInfo bookingInfo =
			bookingService.makeBooking(registeredUser, vehicle1, getLocation(), new Date(), 2, vehicleMap, bookingInfoMap);
		if (bookingInfo == null) {
			System.out.println(vehicle1.getBarCode() + " is not available for rent");
		}
		bookingInfoMap.put(bookingInfo.getBookingId(), bookingInfo);

		// After booking: LLD_Codes.Admin Get All booked vehicles API
		System.out.println("All booked vehicles are: " + admin.getAllBookedVehiclesDetails(vehicleMap, bookingInfoMap));
		System.out.println("BooingINfo DB after one booking: " + bookingInfoMap);
		System.out.println("LLD_Codes.Vehicle DB after booking one vehicle: " + vehicleMap);

		// Doing the booking on same vehicle test
		BookingInfo bookingInfo1 =
			bookingService.makeBooking(registeredUser, vehicle1, getLocation(), new Date(), 2, vehicleMap, bookingInfoMap);
		if (bookingInfo1 == null) {
			System.out.println(vehicle1.getBarCode() + " is not available for rent");
		}

		// Get current status of vehicle API test
		System.out.println("Current status of vehicle1 is " + vehicleService
			.getCurrentStatus(vehicle1.getBarCode(), vehicleMap, bookingInfoMap));
		System.out.println("Current status of vehicle3 is " + vehicleService
			.getCurrentStatus(vehicle3.getBarCode(), vehicleMap, bookingInfoMap));
		System.out.println("Current status of vehicle3 is " + vehicleService
			.getCurrentStatus(vehicle3.getBarCode(), vehicleMap, bookingInfoMap));

		// cancel booking
		bookingService.cancelBooking(0, vehicleMap, bookingInfoMap);

		// making booking after cancellation
		BookingInfo bookingInfo2 =
			bookingService.makeBooking(registeredUser, vehicle1, getLocation(), new Date(), 2, vehicleMap, bookingInfoMap);
		if (bookingInfo2 == null) {
			System.out.println(vehicle1.getBarCode() + " is not available for rent");
		}

		// return and Payment API test
		System.out.println(
			"Payment Info after returning is " + bookingService.returnVehicleAndPay(bookingInfo2, vehicleMap, bookingInfoMap));

		// all search APIs
		System.out.println("All Available vehicles are: " + searchObj.getAllAvailableVehicles(vehicleMap, bookingInfoMap));
		System.out.println("All vehicles whose costPerHour <= 10 are: " + searchObj.getAllVehiclesBasedOnCost(10, vehicleMap));
		System.out.println("All vehicles whose costPerHour <= 110 are: " + searchObj.getAllVehiclesBasedOnCost(110, vehicleMap));
		System.out.println("All vehicles whose vehicleType is car are: " + searchObj
			.getAllVehiclesBasedOnVehicleType(VehicleType.CAR, vehicleMap));

		// Searching option is available to all types of users,i.e, GUEST, REGISTERED< ADMIN
		System.out.println("Registered Users searching all available vehicles: " + registeredUser.searchObj
			.getAllAvailableVehicles(vehicleMap, bookingInfoMap));
		System.out.println("LLD_Codes.Admin Users searching all available vehicles: " + admin.searchObj
			.getAllAvailableVehicles(vehicleMap, bookingInfoMap));
		System.out.println("Guest Users searching all available vehicles: " + new User(true).searchObj
			.getAllAvailableVehicles(vehicleMap, bookingInfoMap));
	}

	public static Location getLocation() {
		return new Location();
	}

}


class User {
	Search searchObj = new Search();
	private final boolean isGuestUser;

	public User(boolean isGuestUser) {
		this.isGuestUser = isGuestUser;
	}
}


class RegisteredUser extends User {

	private final String emailId;
	private String userName;
	private String password;

	public RegisteredUser(String emailId) {
		super(false);
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", RegisteredUser.class.getSimpleName() + "[", "]").add("emailId='" + emailId + "'")
			.toString();
	}
}


class Admin extends RegisteredUser {

	public Admin(String emailId) {
		super(emailId);
	}

	public Vehicle addVehicle(Vehicle vehicle, Map<String, Vehicle> vehicleMap) {
		vehicleMap.put(vehicle.getBarCode(), vehicle);
		return vehicle;
	}

	public Vehicle removeVehicle(String barCode, Map<String, Vehicle> vehicleMap) {
		return vehicleMap.remove(barCode);
	}

	public List<Vehicle> getAllBookedVehiclesDetails(Map<String, Vehicle> vehicleMap, Map<Integer, BookingInfo> bookingInfoMap) {
		List<Vehicle> vehicleList =
				vehicleMap.values().stream().filter(vehicle -> vehicle.getVehicleStatus() == VehicleStatus.RENTED).toList();
		List<Vehicle> ans = new ArrayList<>();
		bookingInfoMap.values().forEach(bookingInfo -> {
			Optional<Vehicle> first =
				vehicleList.stream().filter(vehicle -> vehicle.getBarCode().equals(bookingInfo.getVehicleBarcode())).findFirst();
			first.ifPresent(ans::add);
		});
		return ans;
	}

}


class Vehicle {
	private String barCode;
	private int parkingStallNumber;
	private VehicleType vehicleType;
	private VehicleStatus vehicleStatus;
	private float costPerHour;

	public Vehicle(String barCode, int parkingStallNumber, VehicleType vehicleType, VehicleStatus vehicleStatus, float costPerHour) {
		this.barCode = barCode;
		this.parkingStallNumber = parkingStallNumber;
		this.vehicleType = vehicleType;
		this.vehicleStatus = vehicleStatus;
		this.costPerHour = costPerHour;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public int getParkingStallNumber() {
		return parkingStallNumber;
	}

	public void setParkingStallNumber(int parkingStallNumber) {
		this.parkingStallNumber = parkingStallNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public VehicleStatus getVehicleStatus() {
		return vehicleStatus;
	}

	public void setVehicleStatus(VehicleStatus vehicleStatus) {
		this.vehicleStatus = vehicleStatus;
	}

	public float getCostPerHour() {
		return costPerHour;
	}

	public void setCostPerHour(float costPerHour) {
		this.costPerHour = costPerHour;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Vehicle.class.getSimpleName() + "[", "]").add("barCode='" + barCode + "'")
			.add("vehicleStatus=" + vehicleStatus).toString();

	}
}


class PaymentDetail {
	private final PaymentMode paymentMode;
	private final PaymentStatus paymentStatus;
	private final float paymentAmount;

	public PaymentDetail(PaymentMode paymentMode, PaymentStatus paymentStatus, float paymentAmount) {
		this.paymentMode = paymentMode;
		this.paymentStatus = paymentStatus;
		this.paymentAmount = paymentAmount;
	}

	public PaymentMode getPaymentMode() {
		return paymentMode;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public float getPaymentAmount() {
		return paymentAmount;
	}
}


class PaymentInfo {
	private final int bookingId;
	private int paymentId;
	private final PaymentStatus paymentStatus;
	private final PaymentMode paymentMode;
	private final float amount;
	private final Date paymentDate;

	public PaymentInfo(int bookingId, PaymentStatus paymentStatus, PaymentMode paymentMode, float amount, Date paymentDate) {
		this.bookingId = bookingId;
		this.paymentStatus = paymentStatus;
		this.paymentMode = paymentMode;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", PaymentInfo.class.getSimpleName() + "[", "]").add("bookingId=" + bookingId)
			.add("paymentId=" + paymentId).add("paymentStatus=" + paymentStatus).add("paymentMode=" + paymentMode)
			.add("amount=" + amount).add("paymentDate=" + paymentDate).toString();
	}
}


class BookingInfo {
	private int bookingId;
	private RegisteredUser user;
	private String vehicleBarcode;
	private Date startTime;
	private int duration;
	private Location pickUpLocation;
	private RideStatus rideStatus;

	public BookingInfo() {
	}

	public BookingInfo(RegisteredUser user, String vehicleBarcode, Date startTime, int duration, Location pickUpLocation, RideStatus rideStatus) {
		this.user = user;
		this.vehicleBarcode = vehicleBarcode;
		this.startTime = startTime;
		this.duration = duration;
		this.pickUpLocation = pickUpLocation;
		this.rideStatus = rideStatus;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public RegisteredUser getUser() {
		return user;
	}

	public void setUser(RegisteredUser user) {
		this.user = user;
	}

	public String getVehicleBarcode() {
		return vehicleBarcode;
	}

	public void setVehicleBarcode(String vehicleBarcode) {
		this.vehicleBarcode = vehicleBarcode;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Location getPickUpLocation() {
		return pickUpLocation;
	}

	public void setPickUpLocation(Location pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}

	public RideStatus getRideStatus() {
		return rideStatus;
	}

	public void setRideStatus(RideStatus rideStatus) {
		this.rideStatus = rideStatus;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", BookingInfo.class.getSimpleName() + "[", "]").add("bookingId=" + bookingId)
			.add("user=" + user).add("vehicleBarcode='" + vehicleBarcode + "'").add("startTime=" + startTime)
			.add("duration=" + duration).add("pickUpLocation=" + pickUpLocation).add("rideStatus=" + rideStatus).toString();
	}
}


class Location {
	private int pinCode;
	private String city;
	private String area;
	private String landmark;
	private String state;
	private String country;

	@Override
	public String toString() {
		return new StringJoiner(", ", Location.class.getSimpleName() + "[", "]").add("pinCode=" + pinCode)
			.add("city='" + city + "'").add("area='" + area + "'").add("landmark='" + landmark + "'").add("state='" + state + "'")
			.add("country='" + country + "'").toString();
	}
}


class Search {
	private final BookingService bookingService = new BookingService();

	public List<Vehicle> getAllVehiclesBasedOnVehicleType(VehicleType vehicleType, Map<String, Vehicle> vehicleMap) {
		return vehicleMap.values().stream().filter(vehicle -> vehicle.getVehicleType() == vehicleType)
			.collect(Collectors.toList());
	}

	public List<Vehicle> getAllVehiclesBasedOnCost(float costPerHour, Map<String, Vehicle> vehicleMap) {
		return vehicleMap.values().stream().filter(vehicle -> vehicle.getCostPerHour() <= costPerHour)
			.collect(Collectors.toList());
	}

	public List<Vehicle> getAllAvailableVehicles(Map<String, Vehicle> vehicleMap, Map<Integer, BookingInfo> bookingInfoMap) {
		return vehicleMap.values().stream().filter(vehicle -> {
			BookingInfo bookingInfo = bookingService.getBookingInfo(vehicle.getBarCode(), bookingInfoMap);
			if (bookingInfo == null) {
				return true;
			} else
				return bookingInfo.getRideStatus() == RideStatus.RETURNED;
		}).collect(Collectors.toList());
	}

}


class VehicleService {

	//private final LLD_Codes.BookingService bookingService = new LLD_Codes.BookingService();

	public Vehicle getVehicleFromBarcode(String barcode, Map<String, Vehicle> vehicleMap) {
		return vehicleMap.get(barcode);
	}

	public void save(Vehicle vehicle, Map<String, Vehicle> vehicleMap) {
		vehicleMap.put(vehicle.getBarCode(), vehicle);
	}

	public Object getCurrentStatus(String barCode, Map<String, Vehicle> vehicleMap, Map<Integer, BookingInfo> bookingInfoMap) {
		Vehicle vehicle = getVehicleFromBarcode(barCode, vehicleMap);
		if (vehicle == null) {
			System.out.println("LLD_Codes.Vehicle with barcode " + barCode + " has been removed from the database.");
		}
		if (vehicle.getVehicleStatus() == VehicleStatus.RENTED) {
			return VehicleRentalSystem.bookingService.getBookingInfo(vehicle.getBarCode(), bookingInfoMap);
		}
		return vehicle.getParkingStallNumber();
	}

	public boolean isAvailable(String barCode, Map<String, Vehicle> vehicleMap) {
		Vehicle vehicle = getVehicleFromBarcode(barCode, vehicleMap);
		return vehicle.getVehicleStatus() == VehicleStatus.AVAILABLE;
	}

	public void makeAvailable(Vehicle vehicle, Map<String, Vehicle> vehicleMap) {
		vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
		save(vehicle, vehicleMap);
	}
}


class BookingService {

	private final VehicleService vehicleService = new VehicleService();
	private final PaymentService paymentService = new PaymentService();

	public BookingInfo getBookingInfo(int bookingId, Map<Integer, BookingInfo> bookingInfoMap) {
		return bookingInfoMap.get(bookingId);
	}

	public BookingInfo getBookingInfo(String barcode, Map<Integer, BookingInfo> bookingInfoMap) {
		Optional<BookingInfo> first =
			bookingInfoMap.values().stream().filter(bookingInfo -> bookingInfo.getVehicleBarcode().equalsIgnoreCase(barcode))
				.findFirst();
		return first.orElse(null);
	}

	public BookingInfo makeBooking(RegisteredUser user, Vehicle vehicle, Location location, Date startTime, int duration, Map<String, Vehicle> vehicleMap, Map<Integer, BookingInfo> bookingInfoMap) {
		if (!vehicleService.isAvailable(vehicle.getBarCode(), vehicleMap)) {
			return null;
		}

		BookingInfo bookingInfo =
			new BookingInfo(user, vehicle.getBarCode(), startTime, duration, location, RideStatus.IN_PROGRESS);
		vehicle.setVehicleStatus(VehicleStatus.RENTED);
		vehicleService.save(vehicle, vehicleMap);
		saveBookingInfo(bookingInfo, bookingInfoMap);
		return bookingInfo;
	}

	public void saveBookingInfo(BookingInfo bookingInfo, Map<Integer, BookingInfo> bookingInfoMap) {
		bookingInfoMap.put(bookingInfo.getBookingId(), bookingInfo);
	}

	public void cancelBooking(int bookingId, Map<String, Vehicle> vehicleMap, Map<Integer, BookingInfo> bookingInfoMap) {
		BookingInfo bookingInfo = getBookingInfo(bookingId, bookingInfoMap);
		if (bookingInfo == null) {
			System.out.println("No booking present with given bookingId: " + bookingId);
			return;
		}
		bookingInfo.setRideStatus(RideStatus.CANCELLED);
		Vehicle vehicle = vehicleService.getVehicleFromBarcode(bookingInfo.getVehicleBarcode(), vehicleMap);
		vehicleService.makeAvailable(vehicle, vehicleMap);
		saveBookingInfo(bookingInfo, bookingInfoMap);
	}

	public PaymentInfo returnVehicleAndPay(BookingInfo bookingInfo, Map<String, Vehicle> vehicleMap, Map<Integer, BookingInfo> bookingInfoMap) {
		bookingInfo.setRideStatus(RideStatus.RETURNED);
		Vehicle vehicle = vehicleService.getVehicleFromBarcode(bookingInfo.getVehicleBarcode(), vehicleMap);
		vehicle.setVehicleStatus(VehicleStatus.AVAILABLE);
		vehicleService.save(vehicle, vehicleMap);
		saveBookingInfo(bookingInfo, bookingInfoMap);

		// calculate cost
		return paymentService.calculateCost(vehicle, bookingInfo.getDuration(), bookingInfo.getBookingId());
	}
}


class PaymentService {

	public PaymentDetail makePayment(float amount) {
		return new PaymentDetail(PaymentMode.DC, PaymentStatus.PAID, amount);
	}

	public PaymentInfo calculateCost(Vehicle vehicle, int duration, int bookingId) {
		float costPerHour = vehicle.getCostPerHour();
		float totalCost = costPerHour * duration;

		PaymentDetail paymentDetail = makePayment(totalCost);

		return new PaymentInfo(bookingId, paymentDetail.getPaymentStatus(), paymentDetail.getPaymentMode(),
			paymentDetail.getPaymentAmount(), new Date());
	}
}


