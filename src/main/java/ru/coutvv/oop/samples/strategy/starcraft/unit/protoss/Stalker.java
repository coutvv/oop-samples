package ru.coutvv.oop.samples.strategy.starcraft.unit.protoss;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.HitBehavior;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.MoveBehavior;

public class Stalker extends Unit {
	

	public Stalker(HitBehavior hit, MoveBehavior move) {
		super(hit, move);
	}

	@Override
	public void display() {
		System.out.println("display Stalker");
	}

}
