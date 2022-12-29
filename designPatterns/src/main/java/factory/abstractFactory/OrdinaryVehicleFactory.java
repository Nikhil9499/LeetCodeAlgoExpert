package factory.abstractFactory;

import factory.abstractFactory.ordinaryVehicles.HondaCity;
import factory.abstractFactory.ordinaryVehicles.SwiftDesire;

public class OrdinaryVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle getVehicle(String type) {
        return switch (type) {
            case "HONDA" -> new HondaCity();
            case "SWIFT" -> new SwiftDesire();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "OrdinaryVehicleFactory{}";
    }
}
