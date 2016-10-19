package ru.coutvv.oop.samples.starcraft.building.production;

import ru.coutvv.oop.samples.starcraft.unit.Unit;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Stalker;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Zealot;

public class TaldarimGatewayFactory implements GatewayFactory {

	public Unit createStalker() {
		
		return new Stalker();
	}

	public Unit createZealot() {
		return new Zealot();
	}

}
