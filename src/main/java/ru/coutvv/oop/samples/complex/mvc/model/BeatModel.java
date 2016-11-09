package ru.coutvv.oop.samples.complex.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequencer;

import ru.coutvv.oop.samples.complex.mvc.obs.BPMObserver;
import ru.coutvv.oop.samples.complex.mvc.obs.BeatObserver;

public class BeatModel implements BeatModelInterface, MetaEventListener {

	Sequencer seq;
	List<BeatObserver> beatObs = new ArrayList<>();
	List<BPMObserver> bpmObs = new ArrayList<>();
	int bpm = 90;
	
	@Override
	public void init() {
		try {
			seq = MidiSystem.getSequencer();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		System.out.println("setup midi");
		System.out.println("build track and start");
	}

	@Override
	public void on() {
		seq.start();
		setBPM(90);
	}

	@Override
	public void off() {
		setBPM(0);
		seq.stop();
	}

	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;
		seq.setTempoInBPM(getBPM());
		notifyBPMObservers();
	}

	@Override
	public int getBPM() {
		return bpm;
	}

	@Override
	public void registerObserver(BeatObserver o) {
		beatObs.add(o);
	}

	@Override
	public void removeObserver(BeatObserver o) {
		beatObs.remove(o);
	}

	@Override
	public void registerObsever(BPMObserver o) {
		bpmObs.add(o);
	}

	@Override
	public void removeObserver(BPMObserver o) {
		bpmObs.remove(o);
	}
	
	public void notifyBeatObservers() {
		for(BeatObserver bo : beatObs) {
			bo.updateBeat();
		}
	}
	
	public void notifyBPMObservers() {
		for(BPMObserver bo : bpmObs) {
			bo.update();
		}
	}

	@Override
	public void meta(MetaMessage meta) {
		// TODO Auto-generated method stub
		
	}

}
