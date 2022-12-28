package factory.abstractFactory.ordinaryVehicles;

import factory.abstractFactory.Vehicle;

public class SwiftDesire extends Vehicle {
    public SwiftDesire() {
        super(false);
    }

    @Override
    public String toString() {
        return "SwiftDesire: " + false;
    }
}
