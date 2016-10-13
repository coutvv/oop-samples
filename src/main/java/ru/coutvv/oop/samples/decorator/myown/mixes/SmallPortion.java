package ru.coutvv.oop.samples.decorator.myown.mixes;

import ru.coutvv.oop.samples.decorator.Beverage;
import ru.coutvv.oop.samples.decorator.Condiment;

public class SmallPortion extends Condiment {

	Beverage beverage;
	
	public SmallPortion(Beverage bev) {
		beverage = bev;
	}
	@Override
	public String getDescription() {
		return "Small " + beverage.getDescription();
	}

	private double coefficient = 0.5;
	@Override
	public double cost() {
		return coefficient * beverage.cost();
	}
	
	
}
