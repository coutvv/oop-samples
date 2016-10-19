package ru.coutvv.oop.samples.starcraft.unit.protoss.buff.damage;

import ru.coutvv.oop.samples.starcraft.unit.Unit;
import ru.coutvv.oop.samples.starcraft.unit.protoss.buff.UnitBuff;

/***
 * Что то тут блять не так, чую
 * @author lomovtsevrs
 *
 */
public class ShieldBuff extends UnitBuff {

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
