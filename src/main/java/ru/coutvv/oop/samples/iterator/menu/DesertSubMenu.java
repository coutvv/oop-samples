package ru.coutvv.oop.samples.iterator.menu;

import java.util.ArrayList;
import java.util.Iterator;

public class DesertSubMenu extends AbstractMenu {

	ArrayList<MenuItem> subMenuItems;
	
	public DesertSubMenu() {
		super("DESERT SUB MENU");
		subMenuItems = new ArrayList<>();
		addItem("Щербет",
				"тесто сахар и диабет",
				true,
				5.99);
	}
	
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem mi = new MenuItem(name, description, vegetarian, price);
		subMenuItems.add(mi);
	}
	
	@Override
	public Iterator<MenuItem> createIterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
