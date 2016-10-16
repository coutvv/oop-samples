package ru.coutvv.oop.samples.strategy.realduck;

import ru.coutvv.oop.samples.strategy.superduck.Duck;
import ru.coutvv.oop.samples.strategy.superduck.behavior.JustQuack;
import ru.coutvv.oop.samples.strategy.superduck.behavior.NoFly;

public class DuckDoll extends Duck {

	public DuckDoll() {
		this.flyBehavior = new NoFly();
		this.quackBehavior = new JustQuack();
	}
}
