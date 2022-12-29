package decorator.toppings;

import decorator.pizzas.BasePizza;

public class Mushrooms extends Toppings {

    public Mushrooms(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return this.getBasePizza().cost() + 20;
    }
}
