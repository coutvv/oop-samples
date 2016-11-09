package ru.coutvv.oop.samples.complex.birds.factory;

import ru.coutvv.oop.samples.complex.birds.Quackable;

public abstract class AbstractDuckFactory {

	public abstract Quackable createMallardDuck();
	public abstract Quackable createRedheadDuck();
	public abstract Quackable createDuckCall();
	public abstract Quackable createRubberDuck();
}
