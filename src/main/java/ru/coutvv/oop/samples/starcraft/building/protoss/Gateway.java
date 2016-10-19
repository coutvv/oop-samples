package ru.coutvv.oop.samples.starcraft.building.protoss;

import ru.coutvv.oop.samples.starcraft.building.Building;
import ru.coutvv.oop.samples.starcraft.building.production.GatewayFactory;
import ru.coutvv.oop.samples.starcraft.unit.Unit;
import ru.coutvv.oop.samples.starcraft.unit.UnitType;

public class Gateway extends Building {
	
	GatewayFactory gatewayFactory;
	
	public Gateway(GatewayFactory factory) {
		gatewayFactory = factory;
	}

	@Override
	public Unit createUnit(UnitType type) {
		switch (type) {
		case zealot:
			return gatewayFactory.createZealot();
		case stalker: 
			return gatewayFactory.createStalker();
		default:
			return null;
		}
	}

}
