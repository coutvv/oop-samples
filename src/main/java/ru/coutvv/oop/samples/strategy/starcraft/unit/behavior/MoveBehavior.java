package ru.coutvv.oop.samples.strategy.starcraft.unit.behavior;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;

public interface MoveBehavior {
	void move(Unit unit, double x, double y);
}
