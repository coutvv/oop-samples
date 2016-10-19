package ru.coutvv.oop.samples.command;

import ru.coutvv.oop.samples.command.impl.NoCommand;

public class RemoteControl {

	private final int SLOTS = 3;
	
	Command[] onCommands;
	Command[] offCommands;
	Command undo;
	
	public RemoteControl() {
		Command noCom = new NoCommand();
		
		undo = noCom;
		onCommands = new Command[SLOTS];
		offCommands = new Command[SLOTS];
		for(int i =0 ; i< SLOTS; i++) {
			onCommands[i] = noCom;
			offCommands[i] = noCom;
		}
	}
	
	public void setCommand(int slot, Command on, Command off) {
		if(slot > SLOTS-1) return;
		onCommands[slot] = on;
		offCommands[slot] = off;
	}
	
	public void clickOn(int slot) {
		if(slot > SLOTS-1) return;
		onCommands[slot].execute();
		undo =onCommands[slot]; 
	}
	public void clickOff(int slot) {
		if(slot > SLOTS-1) return;
		offCommands[slot].execute();
		undo =offCommands[slot];
	}
	
	public void undo() { 
		System.out.print("Отмена: ");
		undo.undo();
		undo = new NoCommand();
	}

	@Override
	public String toString() {
		StringBuffer buf = new StringBuffer();
		buf.append("\n---------- Remote Control ------------\n");
		for(int i =0 ; i < 7 ; i++) {
			buf.append("[slot " + i + "]" + onCommands[i].getClass().getName() + " " + 
											offCommands[i].getClass().getName());
		}
		return buf.toString();
	}
}
