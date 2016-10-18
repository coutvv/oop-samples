package ru.coutvv.oop.samples.strategy.starcraft.player.command;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;

public interface Order {
	void command(Unit unit);
}
