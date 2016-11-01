package ru.coutvv.oop.samples.starcraft.unit.behavior;

import ru.coutvv.oop.samples.starcraft.unit.Unit;

public interface MoveBehavior {
	void move(Unit unit, double x, double y);
	
	void moveByFrame(Unit unit, double x, double y);
}
