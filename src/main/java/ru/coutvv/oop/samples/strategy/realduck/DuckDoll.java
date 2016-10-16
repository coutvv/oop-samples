package ru.coutvv.oop.samples.sumuduck.realduck;

import ru.coutvv.oop.samples.sumuduck.superduck.Duck;
import ru.coutvv.oop.samples.sumuduck.superduck.behavior.JustQuack;
import ru.coutvv.oop.samples.sumuduck.superduck.behavior.NoFly;

public class DuckDoll extends Duck {

	public DuckDoll() {
		this.flyBehavior = new NoFly();
		this.quackBehavior = new JustQuack();
	}
}
