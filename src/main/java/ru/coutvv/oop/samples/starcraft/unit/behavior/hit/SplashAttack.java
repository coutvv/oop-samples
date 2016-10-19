package ru.coutvv.oop.samples.starcraft.unit.behavior.hit;

import ru.coutvv.oop.samples.starcraft.unit.Unit;
import ru.coutvv.oop.samples.starcraft.unit.behavior.HitBehavior;

public class SplashAttack implements HitBehavior{

	public double r = 5;
	public void hit(Unit from, Unit to) {
		// TODO Auto-generated method stub
		System.out.println("hit " + to.getClass() + " and splash with radius = " + r);
	}

}
