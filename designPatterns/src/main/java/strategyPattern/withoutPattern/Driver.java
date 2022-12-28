package strategyPattern.withoutPattern;

public class Driver {
    public static void main(String[] args) {
        Vehicle v1 = new SportyVehicle();
        Vehicle v2 = new OffRoadVehicle();
        Vehicle v3 = new NormalVehicle();
        Vehicle v4 = new XYZVehicle();

        // v1 & v2 have same implementation => code duplicate => re-usability compromised
        v1.drive();
        v2.drive();

        // v3 & v4 have same implementation as well
        v3.drive();
        v4.drive();

    }
}
