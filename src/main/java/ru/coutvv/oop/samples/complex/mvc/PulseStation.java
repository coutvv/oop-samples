package ru.coutvv.oop.samples.complex.mvc;

import ru.coutvv.oop.samples.complex.mvc.ctrlr.heart.HeartController;
import ru.coutvv.oop.samples.complex.mvc.model.heart.HeartModel;

public class PulseStation {

	public static void main(String[] args) {
		HeartModel heartModel = new HeartModel();
		new HeartController(heartModel);
	}
}
