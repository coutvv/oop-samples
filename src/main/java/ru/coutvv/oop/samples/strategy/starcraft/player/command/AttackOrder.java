package ru.coutvv.oop.samples.strategy.starcraft.player.command;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;

public class AttackOrder implements Order{

	private Unit who;
	public AttackOrder(Unit who) {
		this.who = who;
	}
	
	public void command(Unit unit) {
		unit.hit(who);
	}

	
}
