package strategyPattern.withPattern;

import strategyPattern.withPattern.driveStrategy.DriveStrategy;
import strategyPattern.withPattern.driveStrategy.NormalDriveStrategyStrategy;

public class XYZVehicle extends Vehicle {
    public XYZVehicle() {
        super(new NormalDriveStrategyStrategy());
    }
}
