package ru.coutvv.oop.samples.fabric.ingredient;

import ru.coutvv.oop.samples.fabric.ingredient.abs.Cheese;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Clams;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Dough;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Pepperoni;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Sauce;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Veggies;
import ru.coutvv.oop.samples.fabric.ingredient.ny.FreshClams;
import ru.coutvv.oop.samples.fabric.ingredient.ny.MarinaraSauce;
import ru.coutvv.oop.samples.fabric.ingredient.ny.ReggianoCheese;
import ru.coutvv.oop.samples.fabric.ingredient.ny.SlicedPepperoni;
import ru.coutvv.oop.samples.fabric.ingredient.ny.ThinCrustDough;
import ru.coutvv.oop.samples.fabric.ingredient.ny.veggies.Garlic;
import ru.coutvv.oop.samples.fabric.ingredient.ny.veggies.Mushroom;
import ru.coutvv.oop.samples.fabric.ingredient.ny.veggies.Onion;
import ru.coutvv.oop.samples.fabric.ingredient.ny.veggies.RedPepper;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	public Dough createDough() {
		Dough res = new ThinCrustDough();
		return res;
	}

	public Sauce createSauce() {
		Sauce res = new MarinaraSauce();
		return res;
	}

	public Cheese createCheese() {
		Cheese res = new ReggianoCheese();
		return res;
	}

	public Veggies[] createVeggies() {
		Veggies[] res = {new Garlic(), new Mushroom(), new Onion(), new RedPepper()};
		return res;
	}

	public Pepperoni createPepperoni() {
		Pepperoni res = new SlicedPepperoni();
		return res;
	}

	public Clams createClam() {
		Clams res = new FreshClams();
		return res;
	}


}
