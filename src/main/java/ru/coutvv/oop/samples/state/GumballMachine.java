package ru.coutvv.oop.samples.state;

import ru.coutvv.oop.samples.state.states.HasQuarterState;
import ru.coutvv.oop.samples.state.states.NoQuarterState;
import ru.coutvv.oop.samples.state.states.SoldOutState;
import ru.coutvv.oop.samples.state.states.SoldState;
import ru.coutvv.oop.samples.state.states.State;
import ru.coutvv.oop.samples.state.states.WinnerState;

public class GumballMachine {
	
	State nqs = new NoQuarterState(this);
	State sos = new SoldOutState(this);
	State ss = new SoldState(this);
	State hqs = new HasQuarterState(this);
	State winner = new WinnerState(this);
	
	State state;
	private int count = 0;
	
	public GumballMachine(int count){ 
		this.count = count;
		if(count > 0) {
			state = nqs;
		} else {
			state = ss;
		}
	}
	
	public void insertQuarter() {
		state.insertQuarter();
	}
	
	public void ejectQuarter() {
		state.ejectQuarter();
	}
	
	public void turnCrank() {
		state.turnCrank();
	}
	
	public void dispense() {
		state.dispense();
	}
	
	public void fill(int count) {
		state.fill(count);
	}
	
	public String toString() {
		return "State: " + state.toString() + "; count: " + count;
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public State getHasQuarterState() {
		return hqs;
	}
	public State getNoQuarterState() {
		return nqs;
	}
	public State getSoldOutState() {
		return sos;
	}
	public State getSoldState() {
		return ss;
	}
	
	public State getWinnerState() {
		return winner;
	}
	
	public boolean hasBalls() {
		return count > 0;
	}
	
	public boolean hasWinBalls() {
		return count > 1;
	}
	
	public void refill(int count) {
		this.count += count;
	}
	
	public void decreaseBalls() {
		count--;
	}
}
