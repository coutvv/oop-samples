package ru.coutvv.oop.samples.test.state;

import org.junit.Test;

import ru.coutvv.oop.samples.state.GumballMachine;

public class TestState {

	
	@Test
	public void testState() {
		GumballMachine gm = new GumballMachine(10);
		for(int i = 0; i < 10 && gm.hasBalls(); i++) {
			buyGumball(gm);
		}
		
		System.out.println(gm);
		gm.fill(123);
		System.out.println(gm);
		for(int i = 0; i< 20; i++) {
			buyGumball(gm);
		}
	}
	
	public void buyGumball(GumballMachine gm) {
		gm.insertQuarter();
		gm.turnCrank();
		gm.dispense();
	}
}
