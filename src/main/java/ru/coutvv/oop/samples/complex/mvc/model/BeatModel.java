package ru.coutvv.oop.samples.complex.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.MetaEventListener;
import javax.sound.midi.MetaMessage;
import javax.sound.midi.MidiChannel;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Synthesizer;

import ru.coutvv.oop.samples.complex.mvc.obs.BPMObserver;
import ru.coutvv.oop.samples.complex.mvc.obs.BeatObserver;

public class BeatModel implements BeatModelInterface, MetaEventListener {

	Synthesizer synth;
	List<BeatObserver> beatObs = new ArrayList<>();
	List<BPMObserver> bpmObs = new ArrayList<>();
	int bpm = 90;
	
	@Override
	public void init() {
		try {
//			seq = MidiSystem.getSequencer();
//			seq.set
//			seq.open();
			synth = MidiSystem.getSynthesizer();
			synth.open();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		System.out.println("setup midi");
		System.out.println("build track and start");
	}
	int s = 50;
	
	Thread music;
	
	void play() {
		
		
		music = new Thread(new Runnable() {
			@Override
			public void run() {
				MidiChannel[]	channels = synth.getChannels();
				MidiChannel	channel = channels[0];
				while(!Thread.currentThread().isInterrupted()) {
					channel.noteOn(s, 50);
					try {
						int time = bpm != 0 ? 60000/bpm : 1000;
						notifyBeatObservers();
						Thread.sleep(time);
					} catch (InterruptedException e) {
//						e.printStackTrace();
					}
					channel.noteOff(s); //s++;
//					if(s > 150) s = 50;
				}
			}
		});
		music.start();
	}

	@Override
	public void on() {
		play();
		setBPM(90);
	}

	@Override
	public void off() {
		setBPM(0);
		if(music != null) {
			while(music.isAlive()) {
				try {
					music.interrupt();
				} catch (Exception e) {
					System.out.println("I'm alive!");
				}
			}
		}
	}

	@Override
	public void setBPM(int bpm) {
		this.bpm = bpm;
//		seq.setTempoInBPM(getBPM());
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
