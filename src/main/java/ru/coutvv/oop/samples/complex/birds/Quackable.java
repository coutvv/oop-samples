package ru.coutvv.oop.samples.complex.birds;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import ru.coutvv.oop.samples.complex.birds.obs.QuackObservable;

public abstract class Quackable implements QuackObservable {
	protected abstract void aQuack();

	private List<Observer> obses = new ArrayList<>();
	@Override
	public void registerObserver(Observer obs) {
		obses.add(obs);
	}

	public void quack() {
		aQuack();
		notifyObservers();
	}
	
	@Override
	public void notifyObservers() {
		for(Observer obs : obses) {
			obs.update(null, this);
		}
	} 
}
