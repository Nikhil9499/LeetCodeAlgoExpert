package adapterPattern.adaptee;

public class CustomWeightMachine implements WeightMachine {
    @Override
    public int getWeightInPounds() {
        return 50;
    }
}
