package ru.coutvv.oop.samples.fabric;

import ru.coutvv.oop.samples.fabric.pizza.Pizza;
import ru.coutvv.oop.samples.fabric.pizza.style.ChicagoStyleCheesePizza;
import ru.coutvv.oop.samples.fabric.pizza.style.ChicagoStylePepperPizza;

public class ChicagoPizzaStore extends PizzaStore {

	public Pizza createPizza(String type) {
		Pizza result = null;
		if(type.equals("cheese")) {
			result = new ChicagoStyleCheesePizza();
		} else if(type.equals("pepper")) {
			result = new ChicagoStylePepperPizza();
		}
		return result;
	}

}
