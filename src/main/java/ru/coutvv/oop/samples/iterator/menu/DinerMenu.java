package ru.coutvv.oop.samples.iterator.menu;

public class DinerMenu extends AbstractMenu {
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;
	
	public DinerMenu() {
		super("LUNCH MENU");
		menuItems = new MenuItem[MAX_ITEMS];
		
		addItem("Vegetarian BLT",
				"(Fakin') Bacon with lettuce & tomato on whole wheat",
				true,
				2.99);
		addItem("BLT",
				"Bacon with lettuce & tomato on whole wheat",
				false,
				2.99);
		addItem("Soup of the day",
				"Soup of the day, with a side of potato salad",
				false,
				3.99);
		addItem("Hotdog",
				"A hot dog, with saurkraut, relish, onions, topped with cheese",
				false,
				3.05);
	}
	
	public void addItem(String name, String description, boolean vegetarian, double price) {
		MenuItem mi = new MenuItem(name, description, vegetarian, price);
		if(numberOfItems >= MAX_ITEMS) {
			System.err.println("Sorry, menu is full! Can't addd item to menu");
		} else {
			menuItems[numberOfItems] = mi;
			numberOfItems++;
		}
	}

	/**
	 * Желательно не знать этот метод, а использовать итератор
	 */
//	public MenuItem[] getMenuItems() {
//		return menuItems;
//	}
	
	public Iterator createIterator() {
		return new Iterator() {
			private int last = 0;
			@Override
			public Object next() {
				if(hasNext()) {
					MenuItem result =menuItems[last]; 
					last++;
					return result;
				}
				return null;
			}
			
			@Override
			public boolean hasNext() {
				return last < numberOfItems;
			}
		};
	}
}
