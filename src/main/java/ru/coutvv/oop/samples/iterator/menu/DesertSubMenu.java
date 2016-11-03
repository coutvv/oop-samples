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
	
	public Iterator<MenuItem> createIterator() {
		return new Iterator<MenuItem>(){
			int last = 0;
			@Override
			public boolean hasNext() {
				return last < subMenuItems.size();
			}

			@Override
			public MenuItem next() {
				if(hasNext()) {
					MenuItem result =subMenuItems.get(last);
					last++;
					return result;
				}
				return null;
			}
			
		};
	}

}
