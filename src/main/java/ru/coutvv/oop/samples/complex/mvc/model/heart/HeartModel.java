package ru.coutvv.oop.samples.complex.mvc.model.heart;

import java.util.ArrayList;
import java.util.List;

import ru.coutvv.oop.samples.complex.mvc.obs.BPMObserver;
import ru.coutvv.oop.samples.complex.mvc.obs.BeatObserver;

public class HeartModel implements HeartModelInterface {

	List<BeatObserver> beatObs = new ArrayList<>();
	List<BPMObserver> bpmObs = new ArrayList<>();

	int heartRate = 90;
	boolean starting = false;

	public HeartModel() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					if(starting) {
						updateBeat();
						updateBPM();
					}heartRate++;
					if(heartRate > 120) heartRate = 60; 
					try {
						Thread.currentThread().sleep(60000 / heartRate);
					} catch (InterruptedException e) {
						
					}
				}
			}
		}).start();
	}
	
	public void startAlert() {
		starting  =true;
	}
	public void stopAlert() {
		starting = false;
	}

	@Override
	public int getHeartRate() {
		return heartRate;
	}

	@Override
	public void registerBeatObserver(BeatObserver obs) {
		beatObs.add(obs);
	}

	@Override
	public void registerBPMObserver(BPMObserver obs) {
		bpmObs.add(obs);
	}

	@Override
	public void removeBeatObserver(BeatObserver obs) {
		beatObs.remove(obs);
	}

	@Override
	public void removeBPMObserver(BPMObserver obs) {
		bpmObs.add(obs);
	}

	@Override
	public void updateBeat() {
		for (BeatObserver bo : beatObs) {
			bo.updateBeat();
		}
	}

	@Override
	public void updateBPM() {
		for (BPMObserver bpmo : bpmObs) {
			bpmo.update();
		}
	}
}
