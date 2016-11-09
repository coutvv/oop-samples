package ru.coutvv.oop.samples.complex.birds.ducks;

import ru.coutvv.oop.samples.complex.birds.Quackable;

public class GooseAdapter extends Quackable{

	Goose goose;
	public GooseAdapter(Goose goose) {
		this.goose = goose;
	}
	@Override
	public void aQuack() {
		goose.honk();
	}

}
