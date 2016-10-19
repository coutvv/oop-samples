package ru.coutvv.oop.samples.test.strategy.starcraft;

import org.junit.Ignore;
import org.junit.Test;

import ru.coutvv.oop.samples.starcraft.building.Building;
import ru.coutvv.oop.samples.starcraft.building.production.GatewayFactory;
import ru.coutvv.oop.samples.starcraft.building.production.NerazimGatewayFactory;
import ru.coutvv.oop.samples.starcraft.building.production.TaldarimGatewayFactory;
import ru.coutvv.oop.samples.starcraft.building.production.TemplarGatewayFactory;
import ru.coutvv.oop.samples.starcraft.building.protoss.Gateway;
import ru.coutvv.oop.samples.starcraft.building.protoss.Nexus;
import ru.coutvv.oop.samples.starcraft.player.ai.EnemyAppearenceSubject;
import ru.coutvv.oop.samples.starcraft.player.ai.EnemyAppearenceSubjectImpl;
import ru.coutvv.oop.samples.starcraft.player.command.MoveOrder;
import ru.coutvv.oop.samples.starcraft.player.command.Order;
import ru.coutvv.oop.samples.starcraft.player.command.observer.ControlPanel;
import ru.coutvv.oop.samples.starcraft.player.command.observer.ControlPanelImpl;
import ru.coutvv.oop.samples.starcraft.unit.Unit;
import ru.coutvv.oop.samples.starcraft.unit.UnitType;
import ru.coutvv.oop.samples.starcraft.unit.behavior.hit.JustAttack;
import ru.coutvv.oop.samples.starcraft.unit.behavior.move.BoostMotion;
import ru.coutvv.oop.samples.starcraft.unit.behavior.move.UniformMotion;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Stalker;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Zealot;
import ru.coutvv.oop.samples.starcraft.unit.protoss.buff.UnitBuff;
import ru.coutvv.oop.samples.starcraft.unit.protoss.buff.damage.MicoseBuff;
import ru.coutvv.oop.samples.starcraft.unit.protoss.buff.damage.ShieldBuff;

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
		Building gateWay = new Gateway(templar);
		Building nexus = new Nexus();
		Unit probe1 = nexus.createUnit(UnitType.probe);
		Unit probe2 = nexus.createUnit(UnitType.probe);
		probe1 = new MicoseBuff(probe1);//пробка под микозом
		probe2 = new ShieldBuff(probe2);//пробка под шилдами
		if(probe1 instanceof UnitBuff) {
			probe1 = ((UnitBuff)probe1).getUnit();//выходим из под микоза
		}
		if(probe1 instanceof UnitBuff) {
			probe2 = ((UnitBuff)probe2).getUnit();//выходим из под шилдов
		}
	}
	
	public GatewayFactory templar = new TemplarGatewayFactory(); 
	
	@Test
	@Ignore
	public void testObserver() { //это не наблюдатель, а мой франкинштейн
		Building gateWay = new Gateway(templar);
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
		Building gateWay = new Gateway(templar);
		Unit zealot = gateWay.createUnit(UnitType.zealot);
		Unit stalker = gateWay.createUnit(UnitType.stalker);
		EnemyAppearenceSubject eas = new EnemyAppearenceSubjectImpl();
		eas.registerUnit(zealot);
		eas.registerUnit(stalker);
		eas.notifyUnits(12, 14);
	}
	
	@Test
	public void testAbstractFactory() {
		GatewayFactory templar = new TemplarGatewayFactory(); 
		GatewayFactory taldarim = new TaldarimGatewayFactory(); 
		GatewayFactory nerazim = new NerazimGatewayFactory();
		
		Building tempGate = new Gateway(templar),
				 nerazGate = new Gateway(nerazim),
				 taldaGate = new Gateway(taldarim);
		
		Unit temp= tempGate.createUnit(UnitType.zealot);
		Unit neraz = nerazGate.createUnit(UnitType.zealot);
		Unit talda = taldaGate.createUnit(UnitType.zealot);
		System.out.println("Taldarim zealot: ");
		logUnitProps(temp);
		System.out.println("Templar zealot: ");
		logUnitProps(neraz);
		System.out.println("Nerazim zealot: ");
		logUnitProps(talda);
	}
	
	private void logUnitProps(Unit unit) {
		unit.display();
		System.out.println("Healthes: " + unit.getHealth());
		System.out.println("Attack range: " + unit.getAttackRange());
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
