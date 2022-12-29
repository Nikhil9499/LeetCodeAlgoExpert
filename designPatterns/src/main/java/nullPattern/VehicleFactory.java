package nullPattern;

public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if ("CAR".equals(type)) {
            return new Car();
        }
        return null;
    }
}
