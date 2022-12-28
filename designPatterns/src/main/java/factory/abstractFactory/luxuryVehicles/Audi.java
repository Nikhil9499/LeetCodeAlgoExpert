package factory.abstractFactory.luxuryVehicles;

import factory.abstractFactory.Vehicle;

public class Audi extends Vehicle {
    public Audi() {
        super(true);
    }

    @Override
    public String toString() {
        return "Audi: " + true;
    }
}
