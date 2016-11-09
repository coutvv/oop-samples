package ru.coutvv.oop.samples.complex.birds.decor;

import ru.coutvv.oop.samples.complex.birds.Quackable;

public class QuackCounter extends Quackable{

	static {
		numberOfQuacks = 0;
	}
	Quackable quackable;
	
	public QuackCounter(Quackable quack) {
		this.quackable = quack;
	}
	
	static int numberOfQuacks;
	@Override
	public void aQuack() {
		quackable.quack();
		numberOfQuacks++;
	}
	
	public static int getQuacks() {
		return numberOfQuacks;
	}

}
