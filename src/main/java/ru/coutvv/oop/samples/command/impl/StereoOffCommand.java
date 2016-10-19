package ru.coutvv.oop.samples.command.impl;

import ru.coutvv.oop.samples.command.Command;
import ru.coutvv.oop.samples.command.estate.Stereo;

public class StereoOffCommand implements Command {

	public void undo() {
		// TODO Auto-generated method stub
		stereo.on();
	}

	Stereo stereo;

	public StereoOffCommand(Stereo stereo) {
		this.stereo = stereo;
	}

	public void execute() {
		stereo.off();
	}

}
