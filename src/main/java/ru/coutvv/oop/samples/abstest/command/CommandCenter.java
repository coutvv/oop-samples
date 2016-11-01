package ru.coutvv.oop.samples.abstest.command;

public interface CommandCenter {

	void addCommand(Command command);
	
	void executeCommands();
}
