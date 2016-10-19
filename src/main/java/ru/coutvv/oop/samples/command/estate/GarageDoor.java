package ru.coutvv.oop.samples.command.estate;

public class GarageDoor {

	public void up() {
		System.out.println("open garage");
	}
	
	public void down() {
		System.out.println("close garage");
	}
	
	public void stop() {
		System.out.println("stop...");
	}
	
	public void lightOn() {
		System.out.println("И озарил свет тьму... ");
	}
	
	public void lightOff() {
		System.out.println("it's dark into garage");
	}
}
