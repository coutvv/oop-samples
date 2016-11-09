package ru.coutvv.oop.samples.complex.birds.obs;

import java.util.Observer;

public interface QuackObservable {
	public void registerObserver(Observer obs);
	public void notifyObservers();
}
