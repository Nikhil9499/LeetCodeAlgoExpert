package strategyPattern.withPattern;

import strategyPattern.withPattern.driveStrategy.SportyDriveStrategy;

public class SportyVehicle extends Vehicle {

    public SportyVehicle() {
        super(new SportyDriveStrategy());
    }
}
