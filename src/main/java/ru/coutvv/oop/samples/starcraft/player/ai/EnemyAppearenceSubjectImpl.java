package ru.coutvv.oop.samples.starcraft.player.ai;

import java.util.ArrayList;
import java.util.List;

import ru.coutvv.oop.samples.starcraft.unit.behavior.AIBehavior;

public class EnemyAppearenceSubjectImpl implements EnemyAppearenceSubject {

	private List<AIBehavior> units = new ArrayList<AIBehavior>();
	
	public void registerUnit(AIBehavior unit) {
		units.add(unit);
	}

	public void removeUnit(AIBehavior unit) {
		units.remove(unit);
	}

	public void notifyUnits(double x, double y) {
		for(AIBehavior unit : units) {
			unit.enemyNear(x, y);
		}
	}

}
