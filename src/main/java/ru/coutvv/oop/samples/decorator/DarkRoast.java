package ru.coutvv.oop.samples.decorator;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		this.description = "Это даркроаст";
	}
	
	public double cost() {
		return 25;
	}
}
