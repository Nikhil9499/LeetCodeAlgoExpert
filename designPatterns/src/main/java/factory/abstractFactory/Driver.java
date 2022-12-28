package factory.abstractFactory;

// Abstract factory is just factory of factory
public class Driver {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = VehicleFactoryFactory.getVehicleFactory("LUXURY");
        System.out.println(vehicleFactory);
        System.out.println(vehicleFactory.getVehicle("AUDI"));
        System.out.println(vehicleFactory.getVehicle("MERCEDES"));

        System.out.println();

        vehicleFactory = VehicleFactoryFactory.getVehicleFactory("ORDINARY");
        System.out.println(vehicleFactory);
        System.out.println(vehicleFactory.getVehicle("HONDA"));
        System.out.println(vehicleFactory.getVehicle("SWIFT"));
    }
}
