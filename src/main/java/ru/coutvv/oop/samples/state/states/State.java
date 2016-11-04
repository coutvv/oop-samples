package ru.coutvv.oop.samples.state.states;

import ru.coutvv.oop.samples.state.GumballMachine;

public abstract class State {

	GumballMachine gm;
	public State(GumballMachine gm) {
		this.gm = gm;
	}
	
	public void insertQuarter() {
		throw new UnsupportedOperationException("Операция запрещена");
	}

	public void ejectQuarter() {
		throw new UnsupportedOperationException("Операция запрещена");
	}

	public void turnCrank() {
		throw new UnsupportedOperationException("Операция запрещена");
	}

	public void dispense() {
		throw new UnsupportedOperationException("Операция запрещена");
	}
	
	public String toString() {
		return this.getClass().getSimpleName();
	}
}
