package ru.coutvv.oop.samples.fabric.pizza;

import ru.coutvv.oop.samples.fabric.ingredient.abs.Cheese;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Clams;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Dough;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Pepperoni;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Sauce;
import ru.coutvv.oop.samples.fabric.ingredient.abs.Veggies;

public abstract class Pizza {

	protected String name;
	protected Dough dough;
	protected Sauce sauce;
	protected Cheese cheese;
	protected Pepperoni pepperoni;
	protected Clams clam;
	protected Veggies veggies[];
	
	public abstract void prepare();
	
	public void bake(){
		System.out.println("bake for 25 min");
	}
	
	public void cut(){
		System.out.println("cutting in fascsist symbol");
	}
	
	public void box() {
		System.out.println("boxing");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
