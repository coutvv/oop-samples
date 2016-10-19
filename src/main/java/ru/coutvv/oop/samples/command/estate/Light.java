package ru.coutvv.oop.samples.command.estate;

public class Light {
	private boolean on = false;
	public void on() {
		on = true;
		System.out.println("lamp is on!");
	}
	
	public void off() {
		on = false;
		System.out.println("lamp is off!");
	}
	
	public boolean isOn() {
		return on;
	}
}
