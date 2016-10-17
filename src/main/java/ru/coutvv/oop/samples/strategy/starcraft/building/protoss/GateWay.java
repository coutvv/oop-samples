package ru.coutvv.oop.samples.strategy.starcraft.building.protoss;

import ru.coutvv.oop.samples.strategy.starcraft.building.Building;
import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.UnitType;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.Stalker;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.Zealot;

public class GateWay extends Building {

	@Override
	public Unit createUnit(UnitType type) {
		switch (type) {
		case zealot:
			return new Zealot();
		case stalker: 
			return new Stalker();
		default:
			return null;
		}
	}

}
