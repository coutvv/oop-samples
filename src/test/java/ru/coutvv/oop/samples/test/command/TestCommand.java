package ru.coutvv.oop.samples.test.command;

import org.junit.Test;

import ru.coutvv.oop.samples.command.Command;
import ru.coutvv.oop.samples.command.SimpleRemoteControl;
import ru.coutvv.oop.samples.command.estate.GarageDoor;
import ru.coutvv.oop.samples.command.estate.Light;
import ru.coutvv.oop.samples.command.impl.GarageDoorOpenCommand;
import ru.coutvv.oop.samples.command.impl.LightOnCommand;

public class TestCommand {

	@Test
	public void test() {
		SimpleRemoteControl src = new SimpleRemoteControl();
		Light light = new Light();
		src.setCommand(new LightOnCommand(light));
		src.buttonWasPressed();
		GarageDoor door = new GarageDoor();
		Command openGarage = new GarageDoorOpenCommand(door);
		SimpleRemoteControl garageControl = new SimpleRemoteControl();
		garageControl.setCommand(openGarage);
		garageControl.buttonWasPressed();
	}
}
