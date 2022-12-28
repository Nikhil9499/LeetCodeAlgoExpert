package factory.abstractFactory.ordinaryVehicles;

import factory.abstractFactory.Vehicle;

public class HondaCity extends Vehicle {
    public HondaCity() {
        super(false);
    }

    @Override
    public String toString() {
        return "HondaCity: " + false;
    }
}
