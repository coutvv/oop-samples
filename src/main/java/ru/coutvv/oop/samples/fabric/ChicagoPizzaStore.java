package ru.coutvv.oop.samples.fabric;

import ru.coutvv.oop.samples.fabric.ingredient.ChicagoPizzaIngredientFactory;
import ru.coutvv.oop.samples.fabric.ingredient.PizzaIngredientFactory;
import ru.coutvv.oop.samples.fabric.pizza.CheesePizza;
import ru.coutvv.oop.samples.fabric.pizza.PepperPizza;
import ru.coutvv.oop.samples.fabric.pizza.Pizza;

public class ChicagoPizzaStore extends PizzaStore {

	public Pizza createPizza(String type) {
		PizzaIngredientFactory factory = new ChicagoPizzaIngredientFactory();
		Pizza result = null;
		if(type.equals("cheese")) {
			result = new CheesePizza(factory);
			result.setName("NY style cheese pizza");
		} else if(type.equals("pepper")) {
			result = new PepperPizza(factory);
			result.setName("NY pep pizza");
		}
		return result;
	}

}
