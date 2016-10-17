package ru.coutvv.oop.samples.strategy.starcraft.building;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.UnitType;
/**
 * Паттерн фабричный метод
 * @author lomovtsevrs
 *
 */
public abstract class Building {
	
	public Unit orderUnit(UnitType type) {
		
		return createUnit(type);
	}
	
	public abstract Unit createUnit(UnitType type);
}
