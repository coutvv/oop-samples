package ru.coutvv.oop.samples.starcraft.player.command;

import ru.coutvv.oop.samples.starcraft.unit.Unit;

public interface Order {
	void command(Unit unit);
}
