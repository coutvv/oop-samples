package ru.coutvv.oop.samples.strategy.starcraft.unit.protoss;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.HitBehavior;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.MoveBehavior;

public class Zealot extends Unit {

	public Zealot(HitBehavior hit, MoveBehavior move) {
		super(hit, move);
	}

	@Override
	public void display() {
		System.out.println("display Zealot");
	}

}
