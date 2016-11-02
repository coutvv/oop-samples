package ru.coutvv.oop.samples.iterator.menu;

import java.util.Iterator;

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
	/**
	 * Паттерн Итератор предоставляет механизм 
	 * последовательного перебора элементов
	 * коллекции без раскрытия её внутреннего 
	 * предсталвения
	 * 
	 * В старкрафте можно юзать для перебора 
	 * юнитов, строений и так далее например
	 */
	public Iterator<MenuItem> createIterator() {
		return new AlternatingDinerMenuIterator(menuItems);
//		return new Iterator<MenuItem>() {
//			private int last = 0;
//			@Override
//			public MenuItem next() {
//				if(hasNext()) {
//					MenuItem result =menuItems[last]; 
//					last++;
//					return result;
//				}
//				return null;
//			}
//			
//			@Override
//			public boolean hasNext() {
//				return last < numberOfItems;
//			}
//		};
	}
}
