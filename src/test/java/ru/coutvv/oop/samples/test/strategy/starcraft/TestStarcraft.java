package ru.coutvv.oop.samples.test.strategy.starcraft;

import org.junit.Ignore;
import org.junit.Test;

import ru.coutvv.oop.samples.strategy.starcraft.building.Building;
import ru.coutvv.oop.samples.strategy.starcraft.building.protoss.GateWay;
import ru.coutvv.oop.samples.strategy.starcraft.building.protoss.Nexus;
import ru.coutvv.oop.samples.strategy.starcraft.player.ai.EnemyAppearenceSubject;
import ru.coutvv.oop.samples.strategy.starcraft.player.ai.EnemyAppearenceSubjectImpl;
import ru.coutvv.oop.samples.strategy.starcraft.player.command.MoveOrder;
import ru.coutvv.oop.samples.strategy.starcraft.player.command.Order;
import ru.coutvv.oop.samples.strategy.starcraft.player.command.observer.ControlPanel;
import ru.coutvv.oop.samples.strategy.starcraft.player.command.observer.ControlPanelImpl;
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

public class TestStarcraft  {

	@Test
	public void test() {
		Unit zealot = createZealot();
		Unit stalker = createStalker();
		while(stalker.isAlive) { 
			zealot.hit(stalker);
		}
		
	}
	
	@Test
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
	
	@Test
	@Ignore
	public void testObserver() { //это не наблюдатель, а мой франкинштейн
		Building gateWay = new GateWay();
		Unit zealot = gateWay.createUnit(UnitType.zealot);
		Unit zealot2 = gateWay.createUnit(UnitType.zealot);
		Unit zealot3= gateWay.createUnit(UnitType.zealot);
		Unit zealot4 = gateWay.createUnit(UnitType.zealot);
		ControlPanel control = new ControlPanelImpl();
		control.selectUnit(zealot);
		control.selectUnit(zealot2);
		control.selectUnit(zealot4);
		Order order = new MoveOrder(40, 50);
		control.controlUnit(order);
	}
	
	@Test
	public void testTrueObserver() {
		Building gateWay = new GateWay();
		Unit zealot = gateWay.createUnit(UnitType.zealot);
		Unit stalker = gateWay.createUnit(UnitType.stalker);
		EnemyAppearenceSubject eas = new EnemyAppearenceSubjectImpl();
		eas.registerUnit(zealot);
		eas.registerUnit(stalker);
		eas.notifyUnits(12, 14);
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
