package ru.coutvv.oop.samples.command.impl;

import ru.coutvv.oop.samples.command.Command;
import ru.coutvv.oop.samples.command.estate.Stereo;

public class StereoOnWithCDCommand implements Command {

	public void undo() {
		stereo.off();
	}

	Stereo stereo;
	
	public StereoOnWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	
	public void execute() {
		stereo.on();
		stereo.setCd();
		stereo.setVolume(11);
	}

}
