package ru.coutvv.oop.samples.strategy.realduck;

import ru.coutvv.oop.samples.strategy.superduck.Duck;
import ru.coutvv.oop.samples.strategy.superduck.behavior.JustQuack;
import ru.coutvv.oop.samples.strategy.superduck.behavior.NoFly;

public class ModelDuck extends Duck {

	public ModelDuck() {
		this.flyBehavior = new NoFly();
		this.quackBehavior = new JustQuack();
	}
}
