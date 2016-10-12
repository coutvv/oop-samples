package ru.coutvv.oop.samples.sumuduck.superduck.behavior;

import ru.coutvv.oop.samples.sumuduck.superduck.QuackBehavior;

public class MuteQuack implements QuackBehavior {

	public void quack() {
		System.out.println("<-- silence -->");
	}

}
