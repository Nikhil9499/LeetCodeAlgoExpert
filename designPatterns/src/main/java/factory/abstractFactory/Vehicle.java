package factory.abstractFactory;

public abstract class Vehicle {
    private boolean isLuxuryVehicle;

    public Vehicle(boolean isLuxuryVehicle) {
        this.isLuxuryVehicle = isLuxuryVehicle;
    }

    public boolean isLuxuryVehicle() {
        return isLuxuryVehicle;
    }

    public void setLuxuryVehicle(boolean luxuryVehicle) {
        isLuxuryVehicle = luxuryVehicle;
    }
}
