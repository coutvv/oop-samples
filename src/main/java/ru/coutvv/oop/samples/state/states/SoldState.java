package ru.coutvv.oop.samples.state.states;

import ru.coutvv.oop.samples.state.GumballMachine;

public class SoldState extends State  {

	public SoldState(GumballMachine gm) {
		super(gm);
	}
	

	@Override
	public void dispense() {
		gm.decreaseBalls();
		System.out.println("you get your balls :-)");
		if(gm.hasBalls()) {
			gm.setState(gm.getNoQuarterState());
		} else {
			gm.setState(gm.getSoldOutState());
		}
		
	}

}
