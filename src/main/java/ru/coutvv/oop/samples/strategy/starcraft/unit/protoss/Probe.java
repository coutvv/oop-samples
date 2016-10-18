package ru.coutvv.oop.samples.strategy.starcraft.unit.protoss;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.HitBehavior;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.MoveBehavior;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.hit.JustAttack;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.move.UniformMotion;

public class Probe extends Unit {

	public Probe() {
		super(new JustAttack(), new UniformMotion());
		
		this.setHealth(40);
		this.setAttackDamage(5);
		this.setAttackRange(0);
		this.setMoveSpeed(5);
	}
	
	public Probe(HitBehavior hit, MoveBehavior move) {
		super(hit, move);
	}

	@Override
	public void display() {
		System.out.println("Show Probe!");
	}

	@Override
	public void enemyNear(double x, double y) {
		System.out.println("Пробке нужно бежать!!!!");
	}
}
