package ru.coutvv.oop.samples.decorator.myown.mixes;

import ru.coutvv.oop.samples.decorator.Beverage;
import ru.coutvv.oop.samples.decorator.Condiment;

public class Soy extends Condiment {
	
	Beverage beverage;
	public Soy(Beverage bev) {
		beverage = bev;
	}


	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		return 7 + beverage.cost();
	}
}
