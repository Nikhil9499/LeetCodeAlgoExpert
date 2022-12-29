package strategyPattern.withPattern;

import strategyPattern.withPattern.driveStrategy.SportyDriveStrategy;

public class OffRoadVehicle extends Vehicle {
    public OffRoadVehicle() {
        super(new SportyDriveStrategy());
    }
}
