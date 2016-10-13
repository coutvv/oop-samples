package ru.coutvv.oop.samples.observer.displays.impl;

import ru.coutvv.oop.samples.observer.Subject;
import ru.coutvv.oop.samples.observer.displays.DisplayElement;
import ru.coutvv.oop.samples.observer.displays.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private String temperature;
	private String humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	
	
	public void display() {
		System.out.println("Current conditions : " + temperature + "Celsius and " + humidity + "% of humidity");
	}


	public void update(String temp, String humidity, String pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}

}
