package ru.coutvv.oop.samples.fabric.pizza;

import java.util.ArrayList;
import java.util.List;

public abstract class Pizza {

	protected String name;
	protected String dough;
	protected String sauce;
	protected List<String> steps = new ArrayList<String>();
	
	public void prepare(){
		System.out.println("--------------------------------------------------------");
		System.out.println("Готовим: " + name);
		System.out.println("Tossing dough... Adding souce... next steps: ");
		for(String step : steps) {
			System.out.println("   " + step);
		}
	}
	
	public void bake(){
		System.out.println("bake for 25 min");
	}
	
	public void cut(){
		System.out.println("cutting in fascsist symbol");
	}
	
	public void box() {
		System.out.println("boxing");
	}
}
