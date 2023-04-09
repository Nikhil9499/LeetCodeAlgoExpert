package factory.abstractFactory;

// Abstract factory is just factory of factory
// With the Factory pattern, you produce instances of implementations (Apple, Banana, Cherry, etc.) of a particular interface -- say, IFruit.
// With the Abstract Factory pattern, you provide a way for anyone to provide their own factory.
// This allows your warehouse to be either an IFruitFactory or an IJuiceFactory, without requiring your warehouse to know anything about fruits or juices.
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
