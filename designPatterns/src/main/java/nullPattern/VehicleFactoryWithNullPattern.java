package nullPattern;

public class VehicleFactoryWithNullPattern {
    public static Vehicle getVehicle(String type) {
        if ("CAR".equals(type)) {
            return new Car();
        }
        return new NullVehicle();
    }
}
