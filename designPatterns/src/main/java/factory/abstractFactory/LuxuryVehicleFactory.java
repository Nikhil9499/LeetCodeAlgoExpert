package factory.abstractFactory;

import factory.abstractFactory.luxuryVehicles.Audi;
import factory.abstractFactory.luxuryVehicles.Mercedes;

public class LuxuryVehicleFactory implements VehicleFactory {

    @Override
    public Vehicle getVehicle(String type) {
        return switch (type) {
            case "AUDI" -> new Audi();
            case "MERCEDES" -> new Mercedes();
            default -> null;
        };
    }

    @Override
    public String toString() {
        return "LuxuryVehicleFactory{}";
    }
}
