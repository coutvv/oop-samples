package ru.coutvv.oop.samples.strategy.starcraft.unit.protoss;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.HitBehavior;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.MoveBehavior;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.hit.JustAttack;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.move.UniformMotion;

public class Stalker extends Unit {
	
	public Stalker() {
		super(new JustAttack(), new UniformMotion());
		this.setAttackDamage(50);
		this.setHealth(120);
		this.setAttackRange(0);
		this.setMoveSpeed(20);
	}

	public Stalker(HitBehavior hit, MoveBehavior move) {
		super(hit, move);
	}

	@Override
	public void display() {
		System.out.println("display Stalker");
	}
	
	@Override
	public void enemyNear(double x, double y) {
		System.out.println("Пустота холодна...(бьём вражину)");
	}

}
