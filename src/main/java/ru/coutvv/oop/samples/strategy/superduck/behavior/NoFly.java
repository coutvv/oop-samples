package ru.coutvv.oop.samples.strategy.superduck.behavior;

import ru.coutvv.oop.samples.strategy.superduck.FlyBehavior;

public class NoFly implements FlyBehavior {

	public void fly() {
		System.out.println("no fly");
	}

}
