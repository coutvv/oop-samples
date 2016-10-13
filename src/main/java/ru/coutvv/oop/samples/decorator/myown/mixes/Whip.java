package ru.coutvv.oop.samples.decorator.myown.mixes;

import ru.coutvv.oop.samples.decorator.Beverage;

public class Whip extends Beverage {
	
	Beverage beverage;
	public Whip(Beverage bev) {
		beverage = bev;
	}


	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return 4 + beverage.cost();
	}
}
