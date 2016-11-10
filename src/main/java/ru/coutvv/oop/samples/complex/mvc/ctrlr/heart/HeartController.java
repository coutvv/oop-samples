package ru.coutvv.oop.samples.complex.mvc.ctrlr.heart;

import ru.coutvv.oop.samples.complex.mvc.ctrlr.ControllerInterface;
import ru.coutvv.oop.samples.complex.mvc.model.heart.HeartAdapter;
import ru.coutvv.oop.samples.complex.mvc.model.heart.HeartModelInterface;
import ru.coutvv.oop.samples.complex.mvc.view.DJView;

public class HeartController implements ControllerInterface{

	HeartModelInterface model;
	DJView view;
	
	public HeartController(HeartModelInterface model) {
		this.model = model;
		view = new DJView(this, new HeartAdapter(model));
		view.createView();
		view.createControls();
		view.disableStartMenuItem();
		view.disableStopMenuItem();
		this.model.startAlert();
	}
	
	@Override
	public void setBPM(int bpm) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void increaseBPM() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decreaseBPM() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

}
