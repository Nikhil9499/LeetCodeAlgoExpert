package decorator.toppings;

import decorator.pizzas.BasePizza;

public class Jalapenos extends Toppings {

    public Jalapenos(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return this.getBasePizza().cost() + 15;
    }
}
