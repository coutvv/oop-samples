package ru.coutvv.oop.samples.fabric.pizza;

import ru.coutvv.oop.samples.fabric.ingredient.PizzaIngredientFactory;

public class PepperPizza extends Pizza{

	PizzaIngredientFactory ingredientFactory;
	
	public PepperPizza(PizzaIngredientFactory factory) {
		this.ingredientFactory = factory;
	}
	
	@Override
	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		pepperoni = ingredientFactory.createPepperoni();
	}
}
