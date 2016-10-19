package ru.coutvv.oop.samples.starcraft.building.production;

import ru.coutvv.oop.samples.starcraft.unit.Unit;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Stalker;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Zealot;

public class TemplarGatewayFactory implements GatewayFactory{

	//темпларные сталкеры стреляют на дистанцию 10
	public Unit createStalker() {
		Unit result = new Stalker();
		result.setAttackRange(10);
		return result;
	}

	//темпларные зилоты танки те ещё
	public Unit createZealot() {
		Unit result = new Zealot();
		result.setHealth(1000);
		return result;
	}

}
