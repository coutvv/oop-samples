package ru.coutvv.oop.samples.iterator.menu;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu extends AbstractMenu {

	ArrayList menuItems;
	
	public PancakeHouseMenu() {
		super("BREAKFAST MENU");
		menuItems = new ArrayList();
		
		addItem("K&Bs Pankace Breakfast",
				"Pancakes witch scrambled eggs, and toast",
				true,
				2.99);
		addItem("Regular Pancake Breakfast",
				"Pancakes with fried eggs, sausage",
				false,
				2.99);
		addItem("Blueberry Pancakes",
				"Pancakes mad with fresh blueberries",
				true,
				6.99);
		addItem("Waffles",
				"Waffles, with your choice of blueberries or strawberries",
				true,
				5.99);
	}

	/**
	 * Желательно не знать этот метод, а использовать итератор
	 */
//	public ArrayList getMenuItems() {
//		return menuItems;
//	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem mi = new MenuItem(name, description, vegetarian, price);
		menuItems.add(mi);
	}
	
	public Iterator createIterator() {
		return menuItems.iterator();
	}
}
