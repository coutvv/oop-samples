package ru.coutvv.oop.samples.strategy.realduck;

import ru.coutvv.oop.samples.strategy.superduck.Duck;
import ru.coutvv.oop.samples.strategy.superduck.behavior.FlyLikeBird;
import ru.coutvv.oop.samples.strategy.superduck.behavior.JustQuack;

public class SimpleDuck extends Duck {

	public SimpleDuck() {
		this.flyBehavior = new FlyLikeBird();
		this.quackBehavior = new JustQuack();
	}
}
