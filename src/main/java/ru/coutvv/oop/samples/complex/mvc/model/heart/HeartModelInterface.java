package ru.coutvv.oop.samples.complex.mvc.model.heart;

import ru.coutvv.oop.samples.complex.mvc.obs.BPMObserver;
import ru.coutvv.oop.samples.complex.mvc.obs.BeatObserver;

public interface HeartModelInterface {

	int getHeartRate();
	void registerBeatObserver(BeatObserver obs);
	void registerBPMObserver(BPMObserver obs);
	
	void removeBeatObserver(BeatObserver obs);
	void removeBPMObserver(BPMObserver obs);
	
	void updateBeat();
	void updateBPM();
	
	public void startAlert();
	public void stopAlert();
	
}
