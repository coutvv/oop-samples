package ru.coutvv.oop.samples.test.strategy;

import junit.framework.TestCase;
import ru.coutvv.oop.samples.strategy.realduck.ModelDuck;
import ru.coutvv.oop.samples.strategy.realduck.SimpleDuck;
import ru.coutvv.oop.samples.strategy.superduck.Duck;
import ru.coutvv.oop.samples.strategy.superduck.behavior.FlyRocketBeahavior;

public class TestDuck extends TestCase  {
	
	public void testDuckService() {
		System.out.println("test");
		Duck duck = new SimpleDuck();
		duck.performFly();
		duck.performQuack();
	}
	
	public void testModelDuck() {
		Duck duck = new ModelDuck();
		duck.performFly();
		duck.setFlyBehavior(new FlyRocketBeahavior());
		duck.performFly();
	}
}
