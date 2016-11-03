package ru.coutvv.oop.samples.composer;

import java.util.Iterator;

import ru.coutvv.oop.samples.composer.menu.MenuComponent;
import ru.coutvv.oop.samples.composer.menu.MenuFactory;
import ru.coutvv.oop.samples.composer.menu.MenuItem;

public class Waitress {
	
	private MenuComponent mainMenu = new MenuFactory().getReadyMenu();
	
	
	public void printMenu() {
		mainMenu.print();
	}
	
	public void printAllVegetarian() {
		System.out.println("<< All vegetarian: >>");
		Iterator<MenuComponent> iter = mainMenu.createIterator();
		while(iter.hasNext()) {
			MenuComponent mc = iter.next();
			if(mc instanceof MenuItem && mc.isVegetarian()) {
				mc.print();
			}
		}
	}
	
}
