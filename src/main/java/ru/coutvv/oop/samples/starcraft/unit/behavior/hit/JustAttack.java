package ru.coutvv.oop.samples.starcraft.unit.behavior.hit;

import ru.coutvv.oop.samples.starcraft.unit.Unit;
import ru.coutvv.oop.samples.starcraft.unit.behavior.HitBehavior;

public class JustAttack implements HitBehavior {

	public void hit(Unit from, Unit to) {
		// TODO Auto-generated method stub
		to.damage(from.getAttackDamage());
		System.out.println("just hit " + to.getClass());
	}

}
