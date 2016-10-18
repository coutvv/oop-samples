package ru.coutvv.oop.samples.test.strategy.starcraft;

import junit.framework.TestCase;
import ru.coutvv.oop.samples.strategy.starcraft.building.Building;
import ru.coutvv.oop.samples.strategy.starcraft.building.protoss.GateWay;
import ru.coutvv.oop.samples.strategy.starcraft.building.protoss.Nexus;
import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.UnitType;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.hit.JustAttack;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.move.BoostMotion;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.move.UniformMotion;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.Stalker;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.Zealot;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.buff.UnitDamageBuff;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.buff.damage.MicoseBuff;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.buff.damage.ShieldBuff;

public class TestStarcraft extends TestCase {

	
	public void test() {
		Unit zealot = createZealot();
		Unit stalker = createStalker();
		while(stalker.isAlive) { 
			zealot.hit(stalker);
		}
		
	}
	
	public void testDecorator() {
		Building gateWay = new GateWay();
		Building nexus = new Nexus();
		Unit probe1 = nexus.createUnit(UnitType.probe);
		Unit probe2 = nexus.createUnit(UnitType.probe);
		probe1 = new MicoseBuff(probe1);//пробка под микозом
		probe2 = new ShieldBuff(probe2);//пробка под шилдами
		if(probe1 instanceof UnitDamageBuff) {
			probe1 = ((UnitDamageBuff)probe1).getUnit();//выходим из под микоза
		}
		if(probe1 instanceof UnitDamageBuff) {
			probe2 = ((UnitDamageBuff)probe2).getUnit();//выходим из под шилдов
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
