package factory.abstractFactory.luxuryVehicles;

import factory.abstractFactory.Vehicle;

public class Mercedes extends Vehicle {
    public Mercedes() {
        super(true);
    }

    @Override
    public String toString() {
        return "Mercedes: " + true;
    }
}
