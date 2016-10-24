package ru.coutvv.oop.samples.templatemethod;

import java.util.Scanner;

public class CoffeeWithHook extends CaffeineBeverage {

	@Override
	public void brew() {
		System.out.println("Dripping Coffee through filter");
	}

	@Override
	public void addCondiments() {
		System.out.println("adding Sugar and Milk");
	}
	
	public boolean customerWantsCondiments() {
		String answer = getUserInput();
		if(answer.contains("y")) {
			return true;
		} else {
			return false;
		}
	}
	
	private String getUserInput() {
		String result = null;
		
		System.out.println("would you like milk and sugar into coffee? (y/n)");
		Scanner scan = new Scanner(System.in);
		result = scan.nextLine();
		scan.close();
		return result;
	}
	

}
