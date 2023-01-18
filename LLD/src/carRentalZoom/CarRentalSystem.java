package carRentalZoom;

import carRentalZoom.costStrategy.DailyCostStrategy;
import carRentalZoom.costStrategy.HourlyCostStrategy;
import carRentalZoom.enums.*;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Builder
public class CarRentalSystem {
    private VehicleInventoryService vehicleInventoryService;
    private StoreInventoryService storeInventoryService;

    public void initialise() {
        addVehicles();
        addStores();
        testInitialisation();
    }

    public void createBooking(City city) {

        // fetch all stores wrt location(city)
        List<Store> storeList = storeInventoryService.getStoresBasedOnCity(city);
        System.out.println(storeList);

        // select a store
        if (storeList.size()>0) {
            Store selectedStore = storeList.get(0);

            // fetch all vehicle wrt selected store
            List<Vehicle> availableVehicles = storeInventoryService.getAvailableVehicles(selectedStore);

            if (availableVehicles.size() > 0) {
                // select a vehicle
                Vehicle selectedVehicle = availableVehicles.get(0);

                // create booking
                Booking booking = Booking.builder()
                        .bookingId(1)
                        .bookingStatus(BookingStatus.SCHEDULED)
                        .bookingType(BookingType.DAILY)
                        .vehicle(selectedVehicle)
                        .createdAt(new Date())
                        .startDate(new Date())
                        .duration(3)
                        .startTime(System.currentTimeMillis())
                        .endTime(System.currentTimeMillis() + 3*24*60*60*1000)
                        .cost(calculateCost())
                        .build();

                // update vehicle status
                storeInventoryService.updateVehicleStatusWrtStore(selectedStore.getStoreId(), selectedVehicle.getVehicleNumber(), VehicleStatus.BOOKED);

                // do payment
                Payment payment = Payment.builder().build();
                boolean isPaymentSuccessful = payment.payBill(booking);
                storeInventoryService.updateVehicleStatusWrtStore(selectedStore.getStoreId(), selectedVehicle.getVehicleNumber(), VehicleStatus.AVAILABLE);
                if (isPaymentSuccessful) {
                    System.out.println("Payment done successfully");
                } else {
                    System.out.println("Payment failed. Try again.");
                }
            } else {
                System.out.println("No vehicles are available for the selected store " + selectedStore.getStoreName());
            }
        } else {
            System.out.println("No stores present in city " + city.name());
        }
    }

    public double calculateCost() {
        return 200;
    }

    private void testInitialisation() {
        System.out.println("Stores available are");
        for(Store store: storeInventoryService.getStores()) {
            System.out.println(store.getStoreName());
            System.out.println("Vehicles available in above store are");
            System.out.println(store.getVehicleList());
        }
    }

    private void addVehicles() {
        Vehicle vehicle = Vehicle.builder()
                .vehicleNumber(1234)
                .vehicleName("NickTest")
                .vehicleStatus(VehicleStatus.AVAILABLE)
                .vehicleType(VehicleType.CAR)
                .distanceTravelled(0)
                .costStrategies(List.of(HourlyCostStrategy.builder().build(), DailyCostStrategy.builder().build()))
                .build();
        vehicleInventoryService.addVehicle(vehicle);
    }

    private void addStores() {
        Store store = Store.builder()
                .storeId(1)
                .storeName("Test")
                .location(Location.builder()
                        .city(City.BANGALORE)
                        .build())
                .vehicleList(vehicleInventoryService.getVehicles())
                .build();
        storeInventoryService.addStore(store);
    }




}
