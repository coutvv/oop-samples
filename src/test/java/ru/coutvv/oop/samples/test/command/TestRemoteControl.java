package ru.coutvv.oop.samples.test.command;

import org.junit.Test;

import ru.coutvv.oop.samples.command.Command;
import ru.coutvv.oop.samples.command.RemoteControl;
import ru.coutvv.oop.samples.command.estate.GarageDoor;
import ru.coutvv.oop.samples.command.estate.Light;
import ru.coutvv.oop.samples.command.estate.Stereo;
import ru.coutvv.oop.samples.command.impl.GarageDoorCloseCommand;
import ru.coutvv.oop.samples.command.impl.GarageDoorOpenCommand;
import ru.coutvv.oop.samples.command.impl.LightOffComand;
import ru.coutvv.oop.samples.command.impl.LightOnCommand;
import ru.coutvv.oop.samples.command.impl.StereoOffCommand;
import ru.coutvv.oop.samples.command.impl.StereoOnWithCDCommand;

public class TestRemoteControl {

	@Test
	public void test() {
		RemoteControl control = new RemoteControl();
		
		Light kitchenLight = new Light();
		Stereo restRoomStereo = new Stereo();
		GarageDoor garage = new GarageDoor();
		
		Command on = new LightOnCommand(kitchenLight);
		Command off = new LightOffComand(kitchenLight);
		control.setCommand(0, on, off);
		
		on = new StereoOnWithCDCommand(restRoomStereo);
		off = new StereoOffCommand(restRoomStereo);
		control.setCommand(1, on, off);
		
		on = new GarageDoorOpenCommand(garage);
		off = new GarageDoorCloseCommand(garage);
		control.setCommand(2, on, off);
		
		
		for(int i = 0; i < 3; i++) {
			control.clickOn(i);
			control.clickOff(i);
		}
		
		//test undo
		
		control.undo();
		control.clickOn(0);
		control.undo();
	}
}
