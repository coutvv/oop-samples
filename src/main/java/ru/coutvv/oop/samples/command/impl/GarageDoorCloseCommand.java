package ru.coutvv.oop.samples.command.impl;

import ru.coutvv.oop.samples.command.Command;
import ru.coutvv.oop.samples.command.estate.GarageDoor;

public class GarageDoorCloseCommand implements Command {

	
	GarageDoor door;
	
	public GarageDoorCloseCommand( GarageDoor garageDoor) {
		door = garageDoor;
	}
	
	public void execute() {
		door.down();
		door.lightOff();
	}

	public void undo() {
		door.up();
		door.lightOn();
	}

}
