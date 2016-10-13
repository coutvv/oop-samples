package ru.coutvv.oop.samples.observer;

import java.util.ArrayList;
import java.util.List;

import ru.coutvv.oop.samples.observer.displays.Observer;

/**
 * Паттерн НАблюдатель определяет отношение
 * "один ко многим" между объектами таким образом, 
 * что при изменении состояния одного объекта 
 * происходит автоматическое оповещение и обновление
 * всех зависимых объектов 
 *  
 * @author lomovtsevrs
 *
 */
public class WeatherData implements Subject{
	
	private List<Observer> observers;
	
	public WeatherData() {
		observers = new ArrayList<Observer>();
	}
	
	private String temperature = "10";
	private String humidity = "10";
	private String pressure = "777";
	
	public String getTemperature() {
		return temperature;
	}
	public String getHumidity() {
		return humidity;
	}
	public String getPressure() {
		return pressure;
	}
	
	public void setProperties(String humidity, String temperature, String pressure) {
		this.pressure= pressure;
		this.temperature = temperature;
		this.humidity = humidity;
		measurementsChanged();
	}

	public void measurementsChanged() {
		notifyObservers();
	}

	public void registerObserver(Observer obs) {
		observers.add(obs);
	}

	public void removeObserver(Observer obs) {
		int i = observers.indexOf(obs);
		if(i >= 0) observers.remove(obs); 
	}

	public void notifyObservers() {
		for(Observer obs : observers) {
			obs.update(getTemperature(), getHumidity(), getPressure());
		}
	}
}
