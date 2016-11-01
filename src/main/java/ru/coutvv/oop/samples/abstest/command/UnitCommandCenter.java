package ru.coutvv.oop.samples.abstest.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс контроля выполнения команд для юнитов(Invoker)
 * 
 * @author lomovtsevrs
 */
public class UnitCommandCenter implements CommandCenter {

	List<Command> commands = new ArrayList<>();
	
	@Override
	public void addCommand(Command command) {
		commands.add(command);
	}
	

	@Override
	public void executeCommands() {
		for(Command cmd : commands) {
			cmd.execute();
		}
	}
	
	
	
	
}
