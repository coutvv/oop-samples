package ru.coutvv.oop.samples.state.states;

import ru.coutvv.oop.samples.state.GumballMachine;

public class SoldOutState extends State  {

	public SoldOutState(GumballMachine gm) {
		super(gm);
	}
	
	public void fill(int count) {
		gm.refill(count);
		gm.setState(gm.getNoQuarterState());
	}

}
