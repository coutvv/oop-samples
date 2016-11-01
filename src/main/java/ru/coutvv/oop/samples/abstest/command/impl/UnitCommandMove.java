package ru.coutvv.oop.samples.abstest.command.impl;

import ru.coutvv.oop.samples.abstest.command.Command;
import ru.coutvv.oop.samples.starcraft.unit.Unit;

/**
 * Конкретная команда(приказ)
 * @author lomovtsevrs
 *
 */
public class UnitCommandMove implements Command {
	
	public Unit unit;
	
	public double x,y;
	
	public UnitCommandMove(Unit unit, double x, double y) {
		this.unit = unit;
		this.x = x;
		this.y = y;
	}

	@Override
	public void execute() {
		if(isEndDistation()) return;
		unit.frameMove(x, y);//движемся
	}
	
	private boolean isEndDistation() {
		boolean result = false;
		if(Math.abs(unit.getX()) - x < 3 && Math.abs(unit.getY() - y) < 3) result = true;
		return result;
	}

}
