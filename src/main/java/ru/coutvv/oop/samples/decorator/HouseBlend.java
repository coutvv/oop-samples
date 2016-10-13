package ru.coutvv.oop.samples.decorator;

public class HouseBlend extends Beverage {

	public HouseBlend() {
		this.description = "Хаусбленд";
	}
	
	public double cost() {
		return 5;
	}
}
