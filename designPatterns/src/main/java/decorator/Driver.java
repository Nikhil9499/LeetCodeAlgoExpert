package decorator;

/*
 *   Decorator pattern is used to prevent class explosion, i.e, having too many classes for different use-cases
 *   Here in our example, we have pizza(P) and some toppings like cheese(C), jalapenos(J), nuggets(N), mushrooms(M), etc
 *   So types will be PC, PM, PN, PJ, PCJ, PCJN, PNM, etc => too many classes.
 *
 *   It has both IS-A & HAS-A relationships.
 * */

import decorator.pizzas.BasePizza;
import decorator.pizzas.ChickenTerminator;
import decorator.pizzas.VegDelight;
import decorator.toppings.ExtraCheese;
import decorator.toppings.Jalapenos;
import decorator.toppings.Mushrooms;

public class Driver {
    public static void main(String[] args) {
        // Chicken Terminator + extra cheese
        BasePizza pizza = new ExtraCheese(new ChickenTerminator());
        System.out.println(pizza.cost());

        // Chicken Terminator + extra cheese + jalapenos + mushrooms
        pizza = new Mushrooms(new Jalapenos(new ExtraCheese(new ChickenTerminator())));
        System.out.println(pizza.cost());

        // VegDelight + extra cheese
        pizza = new ExtraCheese(new VegDelight());
        System.out.println(pizza.cost());

        // VegDelight + extra cheese + jalapenos + mushrooms
        pizza = new Mushrooms(new Jalapenos(new ExtraCheese(new VegDelight())));
        System.out.println(pizza.cost());
    }
}
