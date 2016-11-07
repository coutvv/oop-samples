package ru.coutvv.oop.samples.state.states;

import ru.coutvv.oop.samples.state.GumballMachine;

public class WinnerState extends State {

	public WinnerState(GumballMachine gm) {
		super(gm);
	}
	
	public void dispense() {
		System.out.println("You are winner! You get double balls!");
		gm.decreaseBalls();
		if(gm.hasBalls()) {
			gm.decreaseBalls();
			System.out.println("get your another gumball");
			if(gm.hasBalls()) {
				gm.setState(gm.getNoQuarterState());				
			} else {
				gm.setState(gm.getSoldOutState());
			}
		} else {
			System.out.println("oops! out of gumballs");
			gm.setState(gm.getSoldOutState());
		}
	}

}
