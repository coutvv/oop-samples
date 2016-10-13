package ru.coutvv.oop.samples.observer;

import ru.coutvv.oop.samples.observer.displays.Observer;

public interface Subject {
	void registerObserver(Observer obs);
	void removeObserver(Observer obs);
	
	void notifyObservers();
}
