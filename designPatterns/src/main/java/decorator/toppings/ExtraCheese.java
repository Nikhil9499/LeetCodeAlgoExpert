package decorator.toppings;

import decorator.pizzas.BasePizza;

public class ExtraCheese extends Toppings {

    public ExtraCheese(BasePizza basePizza) {
        super(basePizza);
    }

    @Override
    public int cost() {
        return this.getBasePizza().cost() + 25; // 25 is topping cost. here it is cheese
    }
}
