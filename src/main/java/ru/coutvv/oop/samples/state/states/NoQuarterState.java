package ru.coutvv.oop.samples.state.states;

import ru.coutvv.oop.samples.state.GumballMachine;

public class NoQuarterState extends State  {

	public NoQuarterState(GumballMachine gm) {
		super(gm);
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("You insert quarter");
		gm.setState(gm.getHasQuarterState());
	}

}
