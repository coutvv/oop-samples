package ru.coutvv.oop.samples.test.observer;

import junit.framework.TestCase;
import ru.coutvv.oop.samples.observer.jnative.WeatherData;
import ru.coutvv.oop.samples.observer.jnative.displays.impl.CurrentConditionsDisplay;
import ru.coutvv.oop.samples.observer.jnative.displays.impl.ForecastDisplay;

public class NativeWeatherStation extends TestCase{

	public void test() {
		WeatherData wd = new WeatherData();
		ForecastDisplay fd = new ForecastDisplay(wd);
		CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(wd);
		
		wd.setProperties("12", "32", "2222");
		wd.setProperties("0", "1", "321");
		wd.setProperties("0", "23", "655");
		
	}
}
