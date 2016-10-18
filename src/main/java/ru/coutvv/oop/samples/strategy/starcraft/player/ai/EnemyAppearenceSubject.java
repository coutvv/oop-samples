package ru.coutvv.oop.samples.strategy.starcraft.player.ai;

import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.AIBehavior;

public interface EnemyAppearenceSubject {

	public void registerUnit(AIBehavior unit);
	public void removeUnit(AIBehavior unit);
	public void notifyUnits(double x, double y);
}
