package ru.coutvv.oop.samples.complex.mvc;

import ru.coutvv.oop.samples.complex.mvc.ctrlr.BeatController;
import ru.coutvv.oop.samples.complex.mvc.ctrlr.ControllerInterface;
import ru.coutvv.oop.samples.complex.mvc.model.BeatModel;
import ru.coutvv.oop.samples.complex.mvc.model.BeatModelInterface;

public class DJStation {

	public static void main(String[] args) {
		BeatModelInterface model = new BeatModel();
		ControllerInterface ctrlr = new BeatController(model);
	}
}
