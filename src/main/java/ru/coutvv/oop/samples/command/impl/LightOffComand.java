package ru.coutvv.oop.samples.command.impl;

import ru.coutvv.oop.samples.command.Command;
import ru.coutvv.oop.samples.command.estate.Light;

public class LightOffComand implements Command {

	public void undo() {
		light.on();
	}

	Light light;
	
	public LightOffComand(Light light) {
		this.light = light;
	}
	
	public void execute() {
		light.off();
	}

}
