package ru.coutvv.oop.samples.strategy.starcraft.building.protoss;

import ru.coutvv.oop.samples.strategy.starcraft.building.Building;
import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.UnitType;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.Probe;

public class Nexus extends Building {

	@Override
	public Unit createUnit(UnitType type) {
		Unit result = null;
		switch (type) {
		case probe:
			result = new Probe();
			break;

		default:
			break;
		}
		return result;
	}


}
