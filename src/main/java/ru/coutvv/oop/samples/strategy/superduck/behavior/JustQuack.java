package ru.coutvv.oop.samples.sumuduck.superduck.behavior;

import ru.coutvv.oop.samples.sumuduck.superduck.QuackBehavior;

public class JustQuack implements QuackBehavior {

	public void quack() {
		System.out.println("[SOUND]: quack!");
	}

}
