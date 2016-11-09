package ru.coutvv.oop.samples.complex.mvc.ctrlr;

public interface ControllerInterface {

	public void setBPM(int bpm);
	public void increaseBPM();
	public void decreaseBPM();
	
	public void start();
	public void stop();
}
