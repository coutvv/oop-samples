package ru.coutvv.oop.samples.command.impl;

import ru.coutvv.oop.samples.command.Command;
import ru.coutvv.oop.samples.command.estate.GarageDoor;

public class GarageDoorOpenCommand implements Command{
	
	public void undo() {
		door.down();
		door.lightOff();
	}
	GarageDoor door;
	public GarageDoorOpenCommand(GarageDoor door) {
		this.door = door;
	}
	public void execute() {
		door.up();
		door.lightOn();
	}

}
