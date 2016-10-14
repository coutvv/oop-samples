package ru.coutvv.oop.samples.fabric.ingredient;

import ru.coutvv.oop.samples.fabric.ingredient.abs.Cheese;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Clams;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Dough;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Pepperoni;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Sauce;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Veggies;

public interface PizzaIngredientFactory {

	Dough createDough();
	Sauce createSauce();
	Cheese createCheese();
	Veggies[] createVeggies();
	Pepperoni createPepperoni();
	Clams createClam();
}
