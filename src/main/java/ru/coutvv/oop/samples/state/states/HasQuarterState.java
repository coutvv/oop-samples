package ru.coutvv.oop.samples.state.states;

import ru.coutvv.oop.samples.state.GumballMachine;

public class HasQuarterState extends State {

	public HasQuarterState(GumballMachine gm) {
		super(gm);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void ejectQuarter() {
		System.out.println("quarter is back!");
	}

	@Override
	public void turnCrank() {
		System.out.println("turn turn turn... fap fap fap");
		//тут ещё возможен приз!!
		gm.setState(gm.getSoldState());
	}


}
