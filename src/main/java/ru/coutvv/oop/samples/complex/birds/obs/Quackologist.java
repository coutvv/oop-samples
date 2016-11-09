package ru.coutvv.oop.samples.complex.birds.obs;

import java.util.Observable;
import java.util.Observer;

import ru.coutvv.oop.samples.complex.birds.Quackable;

public class Quackologist implements Observer {

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("сраная утка: " + (Quackable) arg + " крякнула");
	}

}
