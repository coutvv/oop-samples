package ru.coutvv.oop.samples.fabric.ingredient;

import ru.coutvv.oop.samples.fabric.ingredient.abs.Cheese;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Clams;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Dough;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Pepperoni;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Sauce;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Veggies;
import ru.coutvv.oop.samples.fabric.ingredient.chicago.FrozenClams;
import ru.coutvv.oop.samples.fabric.ingredient.chicago.MozzarellaCheese;
import ru.coutvv.oop.samples.fabric.ingredient.chicago.PlumTomatoSauce;
import ru.coutvv.oop.samples.fabric.ingredient.chicago.ThickCrustDough;
import ru.coutvv.oop.samples.fabric.ingredient.chicago.veggies.BlackOlives;
import ru.coutvv.oop.samples.fabric.ingredient.chicago.veggies.EggPlant;
import ru.coutvv.oop.samples.fabric.ingredient.chicago.veggies.Spinach;
import ru.coutvv.oop.samples.fabric.ingredient.ny.SlicedPepperoni;

public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {

	public Dough createDough() {
		Dough res = new ThickCrustDough();
		return res;
	}

	public Sauce createSauce() {
		Sauce res = new PlumTomatoSauce();
		return res;
	}

	public Cheese createCheese() {
		Cheese res = new MozzarellaCheese();
		return res;
	}

	public Veggies[] createVeggies() {
		Veggies[] res = {new BlackOlives(), new EggPlant(), new Spinach()};
		return res;
	}

	public Pepperoni createPepperoni() {
		Pepperoni res = new SlicedPepperoni();
		return res;
	}

	public Clams createClam() {
		Clams res = new FrozenClams();
		return res;
	}


}
