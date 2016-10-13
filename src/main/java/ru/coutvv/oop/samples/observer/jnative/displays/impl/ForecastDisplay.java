package ru.coutvv.oop.samples.observer.jnative.displays.impl;

import java.util.Observable;
import java.util.Observer;

import ru.coutvv.oop.samples.observer.displays.DisplayElement;
import ru.coutvv.oop.samples.observer.jnative.WeatherData;

public class ForecastDisplay implements DisplayElement, Observer {

	Observable observable;
	String lastPressure = "NaN";
	String currentPressure = "Нет данных";
	
	public ForecastDisplay(Observable observable) {
		this.observable = observable;
		observable.addObserver(this);
	}

	public void display() {
		System.out.println("current pressure = " + currentPressure + " last pressure = " + lastPressure);
	}

	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData) {
			WeatherData wd = (WeatherData) o;
			lastPressure = currentPressure;
			currentPressure = wd.getPressure();
			display();
		}
	}

}
