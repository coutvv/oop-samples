package ru.coutvv.oop.samples.command;

public class MacroCommand implements Command {

	Command[] commands;
	
	public MacroCommand(Command[] command) {
		this.commands = command;
	}
	
	public void execute() {
		for(Command com : commands) {
			com.execute();
		}
		
	}

	public void undo() {
		for(Command com : commands) {
			com.undo();
		}
	}

}
