package ru.coutvv.oop.samples.starcraft.unit.protoss.buff.damage;

import ru.coutvv.oop.samples.starcraft.unit.Unit;
import ru.coutvv.oop.samples.starcraft.unit.protoss.buff.UnitBuff;

public class MicoseBuff extends UnitBuff{

	public MicoseBuff(Unit unit) {
		super(unit);
	}

	@Override
	public void damage(double points) {
		this.unit.damage(points+4);
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}

}
