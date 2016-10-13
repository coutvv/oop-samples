package ru.coutvv.oop.samples.decorator;

import ru.coutvv.oop.samples.decorator.Beverage;

public class Decaf extends Beverage {

	public Decaf() {
			this.description = "decaf";
	}
	
	public double cost() {
		return 20;
	}
}
