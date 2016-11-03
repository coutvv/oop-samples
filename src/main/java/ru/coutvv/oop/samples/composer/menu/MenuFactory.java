package ru.coutvv.oop.samples.composer.menu;

public class MenuFactory {
	
	public MenuFactory() {
		createDinerMenu();
		createPancakeHouseMenu();
		createCafeMenu();
	}
	
	public MenuComponent getReadyMenu(){
		return mainMenu;
	}
	
	private MenuComponent mainMenu = new Menu("Главное меню", "Root of menu");
			
	private void createDinerMenu() {
		MenuComponent phm = new Menu("Diner menu", "меню забегаловки");
		MenuItem mi = createItem("Vegetarian BLT",
				"(Fakin') Bacon with lettuce & tomato on whole wheat",
				true,
				2.99);
		phm.add(mi);
		mi = createItem("BLT",
				"Bacon with lettuce & tomato on whole wheat",
				false,
				2.99);
		phm.add(mi);
		mi = createItem("Soup of the day",
				"Soup of the day, with a side of potato salad",
				false,
				3.99);
		phm.add(mi);
		mi = createItem("Hotdog",
				"A hot dog, with saurkraut, relish, onions, topped with cheese",
				false,
				3.05);
		phm.add(mi);
		mainMenu.add(phm);
	}
	private void createPancakeHouseMenu() {
		MenuComponent phm = new Menu("Pancake Menu", "меню блинной");
		phm.add(createItem("K&Bs Pankace Breakfast",
				"Pancakes witch scrambled eggs, and toast",
				true,
				2.99));
		phm.add(createItem("Regular Pancake Breakfast",
				"Pancakes with fried eggs, sausage",
				false,
				2.99));
		phm.add(createItem("Regular Pancake Breakfast",
				"Pancakes with fried eggs, sausage",
				false,
				2.99));
		phm.add(createItem("Waffles",
				"Waffles, with your choice of blueberries or strawberries",
				true,
				5.99));
		mainMenu.add(phm);
	}
	
	private void createCafeMenu() {
		MenuComponent phm = new Menu("Cafe Menu", "меню кофейни");
		MenuItem mi = createItem("Veggie Burget and Air Fries",
				"Veggie burger on a whole wheat bun, lettuce, tomato, and fries",
				true,
				2.88);
		phm.add(mi);
		 mi = createItem("Soup of the day",
				"A cup of the soup of the day, with a side salad",
				false,
				3.88);
		 phm.add(mi);
		 mi = createItem("Burrito",
				"A large burrito, with whole pinto beans, salsa guacamole",
				true,
				1.88);
		 phm.add(mi);
		
		 MenuComponent desert = new Menu("Desert Menu", "Десертное меню кофейни");
		 desert.add(new MenuItem("Щербет", "просто щербет", 1.5, false));
		 phm.add(desert);
		mainMenu.add(phm);
	}
	public MenuItem createItem(String name, String description, boolean vegetarian, double price) {
		MenuItem mi = new MenuItem(name, description,price, vegetarian );
		return mi;
	}
}
