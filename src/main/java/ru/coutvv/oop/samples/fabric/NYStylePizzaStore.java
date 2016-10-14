package ru.coutvv.oop.samples.fabric;

import ru.coutvv.oop.samples.fabric.pizza.Pizza;
import ru.coutvv.oop.samples.fabric.pizza.style.NYStyleCheesePizza;
import ru.coutvv.oop.samples.fabric.pizza.style.NYStylePepperPizza;

public class NYStylePizzaStore extends PizzaStore {

	public Pizza createPizza(String type) {
		Pizza result = null;
		if(type.equals("cheese")) {
			result = new NYStyleCheesePizza();
		} else if(type.equals("pepper")) {
			result = new NYStylePepperPizza();
		}
		return result;
	}

}
