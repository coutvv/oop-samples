package ru.coutvv.oop.samples.state;

public class GumballMachine {
	
	private State state = State.sold_out;
	private int count = 0;
	
	public GumballMachine(int count){ 
		this.count = count;
		if(count > 0) {
			state = State.no_quarter;
		}
	}
	
	public void insertQuarter() {
		switch (state) {
		case no_quarter:
			state = State.has_quarter;
			System.out.println("You inserted a quarter!");
			break;
			
		default:
			throw new UnsupportedOperationException("Куда четвертак суёшь, сукка!!");
		}
	}
	
	public void ejectQuarter() {
		switch (state) {
		case has_quarter:
			state = State.no_quarter;
			System.out.println("returned quarter");
			break;

		default:
			throw new UnsupportedOperationException("Нету нихера же не видишь!!?");
		}
	}
	
	public void turnCrank() {
		switch (state) {
		case has_quarter:
			state = State.sold;
			System.out.println("turn turn turn... fap fap fap");
			break;

		default:
			throw new UnsupportedOperationException("Чё крутишь то!!?");
		}
	}
	
	public void dispense() {
		switch (state) {
		case sold:
			count--;
			System.out.println("A gumball comes rolling out the slot!");
			if(count == 0) {
				state = State.sold_out;
			} else {
				state = State.no_quarter;
			}
			break;

		default:
			throw new UnsupportedOperationException("Ошибка еп");
		}
	}
	
	public String toString() {
		return "State: " + state.toString() + "; count: " + count;
	}
	
}

enum State {
	sold_out,
	no_quarter,
	has_quarter,
	sold
}
