package ru.coutvv.oop.samples.starcraft.building.protoss;

import ru.coutvv.oop.samples.starcraft.building.Building;
import ru.coutvv.oop.samples.starcraft.unit.Unit;
import ru.coutvv.oop.samples.starcraft.unit.UnitType;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Probe;

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
