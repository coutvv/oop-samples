package ru.coutvv.oop.samples.test.strategy.starcraft;

import junit.framework.TestCase;
import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.hit.JustAttack;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.move.BoostMotion;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.move.UniformMotion;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.Stalker;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.Zealot;

public class TestStarcraft extends TestCase {

	
	public void test() {
		Unit zealot = createZealot();
		Unit stalker = createStalker();
		while(stalker.isAlive) { 
			zealot.hit(stalker);
		}
		
	}
	
	private Unit createZealot(){
		Unit zealot = new Zealot(new JustAttack(), new BoostMotion());
		zealot.setAttackDamage(50);
		zealot.setHealth(120);
		zealot.setAttackRange(0);
		zealot.setMoveSpeed(20);
		zealot.setX(10);
		zealot.setY(10);
		return zealot;
	}
	
	private Unit createStalker() {
		Unit stalker = new Stalker(new JustAttack(), new UniformMotion());
		stalker.setHealth(150);
		stalker.setX(50);
		stalker.setY(50);
		
		return stalker;
	}
}
