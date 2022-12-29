package adapterPattern.adapter;

import adapterPattern.adaptee.WeightMachine;

public class CustomAdapterWeightMachine implements AdapterWeightMachine {

    private WeightMachine adapteeWeightMachine; // existing interface

    public CustomAdapterWeightMachine(WeightMachine adapteeWeightMachine) {
        this.adapteeWeightMachine = adapteeWeightMachine;
    }

    @Override
    public int getWeightInKgs() {
        int weightInPounds = adapteeWeightMachine.getWeightInPounds();
        return (int) (weightInPounds * 0.45);
    }
}
