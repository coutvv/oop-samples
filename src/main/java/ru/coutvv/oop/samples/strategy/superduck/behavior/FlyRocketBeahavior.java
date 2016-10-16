package ru.coutvv.oop.samples.strategy.superduck.behavior;

import ru.coutvv.oop.samples.strategy.superduck.FlyBehavior;

public class FlyRocketBeahavior implements FlyBehavior {

	public void fly() {
		System.out.println("object fly by rocket");
	}

}
