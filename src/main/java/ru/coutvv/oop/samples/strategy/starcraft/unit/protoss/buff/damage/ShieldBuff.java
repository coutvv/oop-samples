package ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.buff.damage;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.buff.UnitDamageBuff;

/***
 * Что то тут блять не так, чую
 * @author lomovtsevrs
 *
 */
public class ShieldBuff extends UnitDamageBuff {

	private double armorBuff = 1;
	
	public ShieldBuff(Unit unit) {
		super(unit);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub

	}
	
	public void damage(double points) {
		unit.damage(points - armorBuff);
	}

}
