package ru.coutvv.oop.samples.iterator;

public interface AliceWaitress {

	void printMenu();
	
	void printBreakfastMenu();
	
	void printLunchMenu();
	
	boolean isItemVegetarian(String name) throws Exception;
}
