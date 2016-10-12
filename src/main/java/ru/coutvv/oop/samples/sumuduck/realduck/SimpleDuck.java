package ru.coutvv.oop.samples.sumuduck.realduck;

import ru.coutvv.oop.samples.sumuduck.superduck.Duck;
import ru.coutvv.oop.samples.sumuduck.superduck.behavior.FlyLikeBird;
import ru.coutvv.oop.samples.sumuduck.superduck.behavior.JustQuack;

public class SimpleDuck extends Duck {

	public SimpleDuck() {
		this.flyBehavior = new FlyLikeBird();
		this.quackBehavior = new JustQuack();
	}
}
