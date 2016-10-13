package ru.coutvv.oop.samples.observer.jnative.displays.impl;

import java.util.Observable;
import java.util.Observer;

import ru.coutvv.oop.samples.observer.displays.DisplayElement;
import ru.coutvv.oop.samples.observer.jnative.WeatherData;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private String temperature;
	private String humidity;
	private Observable observable;
	
	public CurrentConditionsDisplay(Observable weatherData) {
		this.observable = weatherData;
		weatherData.addObserver(this);
	}
	
	
	public void display() {
		System.out.println("Current conditions : " + temperature + "Celsius and " + humidity + "% of humidity");
	}


	public void update(Observable o, Object arg) {
		if( o instanceof WeatherData) {
			WeatherData weatherData = (WeatherData) o;
			this.temperature = weatherData.getTemperature();
			this.humidity = weatherData.getHumidity();
			display();
		}
	}

}
