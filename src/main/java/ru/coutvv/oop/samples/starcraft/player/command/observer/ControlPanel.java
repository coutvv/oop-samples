package ru.coutvv.oop.samples.starcraft.player.command.observer;

import ru.coutvv.oop.samples.starcraft.player.command.Order;
import ru.coutvv.oop.samples.starcraft.unit.Unit;

public interface ControlPanel {
	void selectUnit(Unit unit);
	void deselectUnit(Unit unit);
	void controlUnit(Order order);
}
