package ru.coutvv.oop.samples.test.sumuduck;

import junit.framework.TestCase;
import ru.coutvv.oop.samples.sumuduck.realduck.ModelDuck;
import ru.coutvv.oop.samples.sumuduck.realduck.SimpleDuck;
import ru.coutvv.oop.samples.sumuduck.superduck.Duck;
import ru.coutvv.oop.samples.sumuduck.superduck.behavior.FlyRocketBeahavior;

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
