package ru.coutvv.oop.samples.strategy.starcraft.unit.behavior;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;

public interface HitBehavior {
	void hit(Unit from, Unit to);
}
