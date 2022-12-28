package factory.abstractFactory;

public class VehicleFactoryFactory {
    public static VehicleFactory getVehicleFactory(String type) {
        return switch (type) {
            case "ORDINARY" -> new OrdinaryVehicleFactory();
            case "LUXURY" -> new LuxuryVehicleFactory();
            default -> null;
        };
    }
}
