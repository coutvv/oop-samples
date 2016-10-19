package ru.coutvv.oop.samples.command.impl;

import ru.coutvv.oop.samples.command.Command;
import ru.coutvv.oop.samples.command.estate.Light;

public class LightOnCommand implements Command{

	Light light;
	
	public LightOnCommand(Light l) {
		light = l;
	}
	public void execute() {
		light.on();
	}
	public void undo() {
		// TODO Auto-generated method stub
		light.off();
	}


}
