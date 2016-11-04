package ru.coutvv.oop.samples.state;

import ru.coutvv.oop.samples.state.states.HasQuarterState;
import ru.coutvv.oop.samples.state.states.NoQuarterState;
import ru.coutvv.oop.samples.state.states.SoldOutState;
import ru.coutvv.oop.samples.state.states.SoldState;
import ru.coutvv.oop.samples.state.states.State;

public class GumballMachine {
	
	State nqs = new NoQuarterState(this);
	State sos = new SoldOutState(this);
	State ss = new SoldState(this);
	State hqs = new HasQuarterState(this);
	
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
	
	public boolean hasBalls() {
		return count > 0;
	}
	public void decreaseBalls() {
		count--;
	}
}
