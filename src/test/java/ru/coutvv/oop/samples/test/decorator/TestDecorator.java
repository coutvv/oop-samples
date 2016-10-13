package ru.coutvv.oop.samples.test.decorator;

import junit.framework.TestCase;
import ru.coutvv.oop.samples.decorator.Beverage;
import ru.coutvv.oop.samples.decorator.Espresso;
import ru.coutvv.oop.samples.decorator.myown.mixes.Milk;
import ru.coutvv.oop.samples.decorator.myown.mixes.Whip;

public class TestDecorator extends TestCase{

	public void test() {
		Beverage coffee = new Espresso();
		Beverage milk = new Milk();
		Beverage whip = new Whip();
		milk.setMixin(coffee);
		whip.setMixin(milk);
		System.out.println(whip.getDescription());
		System.out.println("COST: " + milk.getCost());
	}
}
