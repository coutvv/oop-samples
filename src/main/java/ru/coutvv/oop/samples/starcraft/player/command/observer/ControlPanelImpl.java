package ru.coutvv.oop.samples.starcraft.player.command.observer;

import java.util.ArrayList;
import java.util.List;

import ru.coutvv.oop.samples.starcraft.player.command.Order;
import ru.coutvv.oop.samples.starcraft.unit.Unit;

/**
 * типа паттерн наблюдатель
 * только как-то не совсем
 * 
 * может быть и другой вообще :(
 * @author coutvv
 */
public class ControlPanelImpl implements ControlPanel {

	private List<Unit> selectedUnits = new ArrayList<Unit>();
	
	public void selectUnit(Unit unit) {
		if(!selectedUnits.contains(unit)) {
			selectedUnits.add(unit);
		}
	}

	public void deselectUnit(Unit unit) {
		if(selectedUnits.contains(unit))
			selectedUnits.remove(unit);
	}

	public void controlUnit(Order order) {
		for(Unit unit : selectedUnits) {
			order.command(unit);
		}
	}

}
