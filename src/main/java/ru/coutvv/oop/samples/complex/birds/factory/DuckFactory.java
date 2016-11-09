package ru.coutvv.oop.samples.complex.birds.factory;

import ru.coutvv.oop.samples.complex.birds.Quackable;
import ru.coutvv.oop.samples.complex.birds.ducks.DuckCall;
import ru.coutvv.oop.samples.complex.birds.ducks.MallardDuck;
import ru.coutvv.oop.samples.complex.birds.ducks.RedheadDuck;
import ru.coutvv.oop.samples.complex.birds.ducks.RubberDuck;

public class DuckFactory extends AbstractDuckFactory {

	@Override
	public Quackable createMallardDuck() {
		return new MallardDuck();
	}

	@Override
	public Quackable createRedheadDuck() {
		return new RedheadDuck();
	}

	@Override
	public Quackable createDuckCall() {
		return new DuckCall();
	}

	@Override
	public Quackable createRubberDuck() {
		return new RubberDuck();
	}

}
