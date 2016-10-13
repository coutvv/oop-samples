package ru.coutvv.oop.samples.observer.jnative;

import java.util.Observable;

/**
 * ЭТот класс использует нативные классы/интерфейсы
 * джавы для реализации шаблона наблюдатель
 *  
 * @author lomovtsevrs
 *
 */
public class WeatherData extends Observable{
	
	
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
		setChanged();
		notifyObservers();
	}

}
