package ru.coutvv.oop.samples.command.estate;

public class Stereo {

	public void on() {
		System.out.println("stereo is on");
	}

	public void off() {
		System.out.println("stereio is off");
	}

	public void setCd() {
		System.out.println("stereo has cd");
	}

	public void setDvd() {
		System.out.println("stereo has dvd");
	}

	public void setRadio() {
		System.out.println("stereo switch to radio");
	}

	public void setVolume(int value) {
		System.out.println("stereo set value = " + value);
	}
}
