package ru.coutvv.oop.samples.strategy.starcraft.player.command;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;

public class MoveOrder implements Order {

	private double x,y;
	public MoveOrder(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void command(Unit unit) {
		unit.move(x, y);
	}

}
