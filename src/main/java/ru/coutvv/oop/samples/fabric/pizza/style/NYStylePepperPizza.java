package ru.coutvv.oop.samples.fabric.pizza.style;

import ru.coutvv.oop.samples.fabric.pizza.Pizza;

public class NYStylePepperPizza extends Pizza {

	public NYStylePepperPizza() {
		name = "NYStylePepperPizza";
		dough = "Thin Crust Dough";
		sauce = "Marinara Sauce";
		steps.add("add Grated Reggino Pepper");
	}
	
	public void box(){ 
		System.out.println("boxing in condom");
	}
}
