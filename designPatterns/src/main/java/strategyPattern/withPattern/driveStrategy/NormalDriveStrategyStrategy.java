package strategyPattern.withPattern.driveStrategy;

public class NormalDriveStrategyStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Normal drive implementation");
    }
}
