package ru.coutvv.oop.samples.decorator.myown.mixes;

import ru.coutvv.oop.samples.decorator.Beverage;
import ru.coutvv.oop.samples.decorator.Condiment;

public class Milk extends Condiment {

	Beverage beverage;
	public Milk(Beverage bev) {
		beverage = bev;
	}


	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	@Override
	public double cost() {
		return 5 + beverage.cost();
	}
	
	
}
