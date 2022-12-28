package strategyPattern.withPattern.driveStrategy;

public class SportyDriveStrategy implements DriveStrategy {
    @Override
    public void drive() {
        System.out.println("Sporty vehicle implementation");
    }
}
