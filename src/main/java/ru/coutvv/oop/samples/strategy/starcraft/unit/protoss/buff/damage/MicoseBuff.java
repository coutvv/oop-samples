package ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.buff.damage;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.protoss.buff.UnitDamageBuff;

public class MicoseBuff extends UnitDamageBuff{

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
