package ru.coutvv.oop.samples.test.observer;

import junit.framework.TestCase;
import ru.coutvv.oop.samples.observer.WeatherData;
import ru.coutvv.oop.samples.observer.displays.impl.CurrentConditionsDisplay;

public class WeatherStation extends TestCase {
	public void test() {
		WeatherData wd = new WeatherData();
		
		CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(wd);
		
		wd.setProperties("13", "15", "799");
		wd.setProperties("0", "16", "123");
		wd.setProperties("0", "0", "700");
		wd.setProperties("12", "38", "600");
	}
}
