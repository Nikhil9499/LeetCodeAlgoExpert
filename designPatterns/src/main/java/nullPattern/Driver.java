package nullPattern;

public class Driver {
    public static void main(String[] args) {
        Vehicle vehicle = VehicleFactoryWithNullPattern.getVehicle("CAR");
        System.out.println(vehicle.getFuelCapacity()); // No need to have null check bcoz vehicle will never be null

        Vehicle vehicle2 = VehicleFactory.getVehicle("CAR");
        if (vehicle2 != null) {
            System.out.println(vehicle2.getFuelCapacity());
        } else {
            System.out.println("vehicle2 is NULL");
        }

        vehicle = VehicleFactoryWithNullPattern.getVehicle("BIKE");
        System.out.println(vehicle.getFuelCapacity());// No need to have null check bcoz vehicle will never be null

        vehicle2 = VehicleFactory.getVehicle("BIKE");
        if (vehicle2 != null) {
            System.out.println(vehicle2.getFuelCapacity());
        } else {
            System.out.println("vehicle2 is NULL");
        }
    }
}
