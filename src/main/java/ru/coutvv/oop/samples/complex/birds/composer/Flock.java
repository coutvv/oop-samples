package ru.coutvv.oop.samples.complex.birds.composer;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import ru.coutvv.oop.samples.complex.birds.Quackable;

public class Flock extends Quackable{

	List<Quackable> quackers = new ArrayList<>();
	
	public void add(Quackable q) {
		quackers.add(q);
	}
	
	@Override
	public void aQuack() {
		for(Quackable q : quackers) {
			q.quack();
		}
	}
	
	@Override
	public void registerObserver(Observer obs) {
		for(Quackable q : quackers) {
			q.registerObserver(obs);
		}
	}

}
