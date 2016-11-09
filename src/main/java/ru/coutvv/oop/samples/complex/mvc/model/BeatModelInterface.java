package ru.coutvv.oop.samples.complex.mvc.model;

import ru.coutvv.oop.samples.complex.mvc.obs.BPMObserver;
import ru.coutvv.oop.samples.complex.mvc.obs.BeatObserver;

public interface BeatModelInterface {

	/**
	 * вызывается после создания экземпляра BeatModel
	 */
	void init();
	
	void on();
	void off();
	
	void setBPM(int bpm);
	int getBPM();
	
	void registerObserver(BeatObserver o );
	void removeObserver(BeatObserver o);
	void registerObsever(BPMObserver o);
	void removeObserver(BPMObserver o);
}
