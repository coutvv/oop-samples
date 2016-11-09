package ru.coutvv.oop.samples.complex.mvc.ctrlr;

import ru.coutvv.oop.samples.complex.mvc.model.BeatModelInterface;
import ru.coutvv.oop.samples.complex.mvc.view.DJView;

public class BeatController implements ControllerInterface {

	BeatModelInterface model;
	DJView view;
	
	public BeatController(BeatModelInterface model) {
		this.model = model;
		this.view = new DJView(this, model);
		view.createView();
		view.createControls();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
		model.init();
	}
	
	@Override
	public void setBPM(int bpm) {
		model.setBPM(bpm);
	}

	@Override
	public void increaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm++);
	}

	@Override
	public void decreaseBPM() {
		int bpm = model.getBPM();
		model.setBPM(bpm--);
	}

	@Override
	public void start() {
		model.on();
		view.disableStartMenuItem();
		view.enableStopMenuItem();
	}

	@Override
	public void stop() {
		model.off();
		view.disableStopMenuItem();
		view.enableStartMenuItem();
	}

}
