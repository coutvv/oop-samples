package ru.coutvv.oop.samples.complex.birds.factory;

import ru.coutvv.oop.samples.complex.birds.Quackable;
import ru.coutvv.oop.samples.complex.birds.decor.QuackCounter;

public class CountingDuckFactory extends AbstractDuckFactory {

	DuckFactory df = new DuckFactory();
	@Override
	public Quackable createMallardDuck() {
		return new QuackCounter(df.createMallardDuck());
	}

	@Override
	public Quackable createRedheadDuck() {
		return new QuackCounter(df.createRedheadDuck());
	}

	@Override
	public Quackable createDuckCall() {
		return new QuackCounter(df.createDuckCall());
	}

	@Override
	public Quackable createRubberDuck() {
		return new QuackCounter(df.createRubberDuck());
	}

}
