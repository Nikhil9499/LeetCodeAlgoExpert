package decorator.toppings;

import decorator.pizzas.BasePizza;

// Decorator pattern: both IS-A & HAS-A relationships
public abstract class Toppings extends BasePizza {
    private BasePizza basePizza;

    public Toppings(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    public BasePizza getBasePizza() {
        return basePizza;
    }

    public void setBasePizza(BasePizza basePizza) {
        this.basePizza = basePizza;
    }
}
