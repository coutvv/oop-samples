package ru.coutvv.oop.samples.strategy.superduck.behavior;

import ru.coutvv.oop.samples.strategy.superduck.QuackBehavior;

public class JustQuack implements QuackBehavior {

	public void quack() {
		System.out.println("[SOUND]: quack!");
	}

}
