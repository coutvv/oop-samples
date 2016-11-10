package ru.coutvv.oop.samples.complex.mvc.model.heart;

import ru.coutvv.oop.samples.complex.mvc.model.BeatModelInterface;
import ru.coutvv.oop.samples.complex.mvc.obs.BPMObserver;
import ru.coutvv.oop.samples.complex.mvc.obs.BeatObserver;

public class HeartAdapter implements BeatModelInterface {

	HeartModelInterface hm;
	
	public HeartAdapter(HeartModelInterface model) {
		hm = model;
	}
	@Override
	public void init() {
		
	}

	@Override
	public void on() {
	}

	@Override
	public void off() {
	}

	@Override
	public void setBPM(int bpm) {
	}

	@Override
	public int getBPM() {
		return hm.getHeartRate();
	}

	@Override
	public void registerObserver(BeatObserver o) {
		hm.registerBeatObserver(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		hm.removeBeatObserver(o);
	}

	@Override
	public void registerObsever(BPMObserver o) {
		hm.registerBPMObserver(o);
	}

	@Override
	public void removeObserver(BPMObserver o) {
		hm.removeBPMObserver(o);
	}

}
