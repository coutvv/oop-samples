package ru.coutvv.oop.samples.strategy.starcraft.unit.protoss;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.HitBehavior;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.MoveBehavior;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.hit.JustAttack;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.move.UniformMotion;

public class Zealot extends Unit {
	
	public Zealot() {
		super(new JustAttack(), new UniformMotion());
		this.setAttackDamage(50);
		this.setHealth(120);
		this.setAttackRange(0);
		this.setMoveSpeed(20);
	}
	
	public Zealot(HitBehavior hit, MoveBehavior move) {
		super(hit, move);
	}

	@Override
	public void display() {
		System.out.println("display Zealot");
	}
	
	@Override
	public void enemyNear(double x, double y) {
		System.out.println("Май лайф фо АЙЮР!1!!!!");
	}

}
