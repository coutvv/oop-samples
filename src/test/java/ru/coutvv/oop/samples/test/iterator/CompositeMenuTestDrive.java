package ru.coutvv.oop.samples.test.iterator;

import org.junit.Test;

import ru.coutvv.oop.samples.composer.Waitress;

public class CompositeMenuTestDrive {

	
	@Test
	public void testOn() {
		Waitress w = new Waitress();
		w.printMenu();
		
		w.printAllVegetarian();
	}
}
