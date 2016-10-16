package ru.coutvv.oop.samples.strategy.superduck.behavior;

import ru.coutvv.oop.samples.strategy.superduck.QuackBehavior;

public class MuteQuack implements QuackBehavior {

	public void quack() {
		System.out.println("<-- silence -->");
	}

}
