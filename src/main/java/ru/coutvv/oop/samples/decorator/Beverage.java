package ru.coutvv.oop.samples.decorator;

public abstract class Beverage {

	
	public abstract double cost();
	
	protected String description = "Unknown Beverage";
	
	public String getDescription() {
		return description;
	}
}
