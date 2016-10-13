package ru.coutvv.oop.samples.decorator;

public class Espresso extends Beverage {

	public Espresso() {
		this.description = "Espresso";
	}
	
	public double cost() {
		return 22;
	}
}
