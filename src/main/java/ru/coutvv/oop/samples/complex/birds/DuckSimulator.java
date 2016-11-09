package ru.coutvv.oop.samples.complex.birds;

import ru.coutvv.oop.samples.complex.birds.composer.Flock;
import ru.coutvv.oop.samples.complex.birds.decor.QuackCounter;
import ru.coutvv.oop.samples.complex.birds.ducks.Goose;
import ru.coutvv.oop.samples.complex.birds.ducks.GooseAdapter;
import ru.coutvv.oop.samples.complex.birds.factory.AbstractDuckFactory;
import ru.coutvv.oop.samples.complex.birds.factory.CountingDuckFactory;
import ru.coutvv.oop.samples.complex.birds.obs.Quackologist;

public class DuckSimulator {
	void simulate(AbstractDuckFactory adf) {
		
		System.out.println("Duck simulator : ");
		Quackable obsDUck = adf.createMallardDuck();
//		obsDUck.registerObserver(new Quackologist());
		Flock flock = new Flock();
		flock.add(obsDUck);
		flock.add(adf.createRubberDuck());
		flock.add(adf.createRedheadDuck());
		flock.add(adf.createDuckCall());
//		list.add(adf.create);
		flock.add(new GooseAdapter(new Goose()));
		flock.registerObserver(new Quackologist());
//		simulate(list);
//		flock.quack();
		simulate(flock);
		System.err.println(QuackCounter.getQuacks());
	}
	
	void simulate(Quackable q) {
		q.quack();
	}
	public static void main(String[] args) {
		new DuckSimulator().simulate(new CountingDuckFactory());
	}
}
