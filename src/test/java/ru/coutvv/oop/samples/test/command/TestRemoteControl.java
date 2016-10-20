package ru.coutvv.oop.samples.test.command;

import org.junit.Ignore;
import org.junit.Test;

import ru.coutvv.oop.samples.command.Command;
import ru.coutvv.oop.samples.command.MacroCommand;
import ru.coutvv.oop.samples.command.RemoteControl;
import ru.coutvv.oop.samples.command.estate.CeilingFan;
import ru.coutvv.oop.samples.command.estate.GarageDoor;
import ru.coutvv.oop.samples.command.estate.Light;
import ru.coutvv.oop.samples.command.estate.Stereo;
import ru.coutvv.oop.samples.command.impl.CeilingFanHighCommand;
import ru.coutvv.oop.samples.command.impl.CeilingFanOffCommand;
import ru.coutvv.oop.samples.command.impl.GarageDoorCloseCommand;
import ru.coutvv.oop.samples.command.impl.GarageDoorOpenCommand;
import ru.coutvv.oop.samples.command.impl.LightOffComand;
import ru.coutvv.oop.samples.command.impl.LightOnCommand;
import ru.coutvv.oop.samples.command.impl.StereoOffCommand;
import ru.coutvv.oop.samples.command.impl.StereoOnWithCDCommand;

public class TestRemoteControl {

	@Test
	@Ignore
	public void test() {
		RemoteControl control = createJoystick();

		for (int i = 0; i < 3; i++) {
			control.clickOn(i);
			control.clickOff(i);
		}

		// test undo

		control.undo();
		control.clickOn(0);
		control.undo();

		// test ceiling

		control.clickOn(3);
		control.clickOff(3);
		control.undo();
		
		//party!!!
		control.clickOn(4);
		System.out.println("the end of party");
		//party over
		control.clickOff(4);
		
		
		
	}

	private RemoteControl createJoystick() {
		RemoteControl control = new RemoteControl();

		///devices
		Light kitchenLight = new Light();
		Stereo restRoomStereo = new Stereo();
		GarageDoor garage = new GarageDoor();
		CeilingFan fan = new CeilingFan("kitchen");

		Command on = new LightOnCommand(kitchenLight);
		Command off = new LightOffComand(kitchenLight);
		control.setCommand(0, on, off);

		on = new StereoOnWithCDCommand(restRoomStereo);
		off = new StereoOffCommand(restRoomStereo);
		control.setCommand(1, on, off);

		on = new GarageDoorOpenCommand(garage);
		off = new GarageDoorCloseCommand(garage);
		control.setCommand(2, on, off);

		on = new CeilingFanHighCommand(fan);
		off = new CeilingFanOffCommand(fan);
		control.setCommand(3, on, off);
		
		//macrocommand
		Command[] partyOn = {new LightOnCommand(kitchenLight),new StereoOnWithCDCommand(restRoomStereo),new CeilingFanHighCommand(fan)};
		Command[] partyOff = {new LightOffComand(kitchenLight),new StereoOffCommand(restRoomStereo),new CeilingFanOffCommand(fan)};
		control.setCommand(4, new MacroCommand(partyOn), new MacroCommand(partyOff));
		

		return control;
	}
	
	
	@Test
	public void tsest() {
		// TODO Auto-generated method stub
		String s = "фцукащо йуко фв";
		System.out.println(s);
	}
}
