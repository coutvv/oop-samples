package ru.coutvv.oop.samples.test.templatemethod;

import org.junit.Ignore;
import org.junit.Test;

import ru.coutvv.oop.samples.templatemethod.CaffeineBeverage;
import ru.coutvv.oop.samples.templatemethod.CoffeeWithHook;
import ru.coutvv.oop.samples.templatemethod.graphic.MyFrame;

public class TestHook {

	@Ignore
	@Test
	public void testHook() {
		CaffeineBeverage cup = new CoffeeWithHook();
		cup.prepareRecipe();
	}
	
	@Test
	public void testFrame() {
		MyFrame mf = new  MyFrame("fucking frame");
		//надо в отдельном потоке(main) запускать, так отваливается
	}
}
