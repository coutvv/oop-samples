package ru.coutvv.oop.samples.state.states;

import java.util.Random;

import ru.coutvv.oop.samples.state.GumballMachine;

public class HasQuarterState extends State {
	
	Random randomWinner = new Random(System.currentTimeMillis());

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
		int winner = randomWinner.nextInt(10);//10% chance
		if((winner == 0) && gm.hasWinBalls()) {
			gm.setState(gm.getWinnerState());
		} else {
			gm.setState(gm.getSoldState());
		}
	}


}
