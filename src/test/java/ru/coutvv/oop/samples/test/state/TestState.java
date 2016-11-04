package ru.coutvv.oop.samples.test.state;

import org.junit.Test;

import ru.coutvv.oop.samples.state.GumballMachine;

public class TestState {

	
	@Test
	public void testState() {
		GumballMachine gm = new GumballMachine(10);
		System.out.println(gm);
		gm.insertQuarter();
		gm.turnCrank();
		gm.dispense();
		System.out.println(gm);
	}
}
