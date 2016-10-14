package ru.coutvv.oop.samples.fabric.pizza.style;

import ru.coutvv.oop.samples.fabric.pizza.Pizza;

public class ChicagoStyleCheesePizza  extends Pizza {

	public ChicagoStyleCheesePizza() {
		name = "ChicagoStyleCheesePizza";
		dough = "Extra thic crust dough";
		sauce = "plum tomato sauce";
		steps.add("mozzarella cheese");
	}
	
	public void cut() {
		System.out.println("Режем клиньями, йеп!");
	}

}
