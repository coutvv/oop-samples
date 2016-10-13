package ru.coutvv.oop.samples.decorator.myown.mixes;

import ru.coutvv.oop.samples.decorator.Beverage;
import ru.coutvv.oop.samples.decorator.Condiment;

public class Mocha extends Condiment {
	
	Beverage beverage;
	
	public Mocha(Beverage bev) {
		this.beverage = bev;
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	@Override
	public double cost() {
		return 2 + beverage.cost();
	}
}
