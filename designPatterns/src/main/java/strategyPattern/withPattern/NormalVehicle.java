package strategyPattern.withPattern;

import strategyPattern.withPattern.driveStrategy.NormalDriveStrategyStrategy;

public class NormalVehicle extends Vehicle {
    public NormalVehicle() {
        super(new NormalDriveStrategyStrategy());
    }
}
