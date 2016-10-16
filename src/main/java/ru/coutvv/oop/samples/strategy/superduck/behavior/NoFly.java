package ru.coutvv.oop.samples.sumuduck.superduck.behavior;

import ru.coutvv.oop.samples.sumuduck.superduck.FlyBehavior;

public class NoFly implements FlyBehavior {

	public void fly() {
		System.out.println("no fly");
	}

}
