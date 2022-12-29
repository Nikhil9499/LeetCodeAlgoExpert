package adapterPattern;

import adapterPattern.adaptee.CustomWeightMachine;
import adapterPattern.adapter.AdapterWeightMachine;
import adapterPattern.adapter.CustomAdapterWeightMachine;

/*  Adapter DP is used as a bridge between client and existing interface when clients want
    different contract/implementation other than the existing one.
    In the example, existing interface gives weight in pounds but clients want weight in kgs.
    To bridge the gap, adapter comes in between.*/

public class Client {
    public static void main(String[] args) {
        AdapterWeightMachine adapterWeightMachine = new CustomAdapterWeightMachine(new CustomWeightMachine());
        System.out.println(adapterWeightMachine.getWeightInKgs() + " kgs");
    }
}
