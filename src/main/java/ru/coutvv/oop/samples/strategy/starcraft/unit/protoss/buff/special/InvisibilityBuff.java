package ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.buff.special;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.buff.UnitBuff;

/**
 * Типа невидимость
 * @author lomovtsevrs
 *
 */
public class InvisibilityBuff extends UnitBuff {

	public InvisibilityBuff(Unit unit) {
		super(unit);
	}

	@Override
	public void damage(double points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		System.out.println("типа невидимый юнит");
	}

}
