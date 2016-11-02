package ru.coutvv.oop.samples.iterator.menu;

import java.util.Hashtable;
import java.util.Iterator;

public class CafeMenu extends AbstractMenu {

	

	Hashtable menuItems = new Hashtable();
	
	public CafeMenu() {
		super("CAFE MENU");
		addItem("Veggie Burget and Air Fries",
				"Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
				true,
				2.88);
		addItem("Soup of the day",
				"A cup of the soup of the day, with a side salad",
				false,
				3.88);
		addItem("Burrito",
				"A large burrito, with whole pinto beans, salsa guacamole",
				true,
				1.88);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem mi = new MenuItem(name, description, vegetarian, price);
		menuItems.put(mi.getName(), mi);
	}
	
	@Override
	public Iterator<MenuItem> createIterator() {
		return menuItems.values().iterator();
	}
}
