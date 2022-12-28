package strategyPattern.withPattern;

import strategyPattern.withPattern.driveStrategy.NormalDriveStrategyStrategy;
import strategyPattern.withPattern.driveStrategy.SportyDriveStrategy;

//Strategy pattern is used when children within inheritance tree same some common methods.
// Here sporty implementation is the common one

public class Driver {
    public static void main(String[] args) {
        Vehicle v1 = new SportyVehicle();
        Vehicle v3 = new OffRoadVehicle();
        Vehicle v2 = new NormalVehicle();
        Vehicle v4 = new XYZVehicle();

        // v1 & v2 have same implementation => same code => re-usability not compromised
        v1.drive();
        v2.drive();

        // v3 & v4 have same implementation as well
        v3.drive();
        v4.drive();

    }
}
