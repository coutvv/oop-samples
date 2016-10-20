package ru.coutvv.oop.samples.command.impl;

import ru.coutvv.oop.samples.command.Command;
import ru.coutvv.oop.samples.command.estate.CeilingFan;

public class CeilingFanHighCommand implements Command{

	CeilingFan fan;
	int prevSpeed;
	
	public CeilingFanHighCommand(CeilingFan fan) {
		this.fan = fan;
		prevSpeed = fan.getSpeed();
	}
	
	public void execute() {
		prevSpeed = fan.getSpeed();
		fan.high();
	}

	public void undo() {
		if(prevSpeed == CeilingFan.HIGH)
			fan.high();
		else if (prevSpeed == CeilingFan.MEDIUM)
			fan.medium();
		else if(prevSpeed == CeilingFan.LOW) 
			fan.low();
		else fan.off();
	}

}
