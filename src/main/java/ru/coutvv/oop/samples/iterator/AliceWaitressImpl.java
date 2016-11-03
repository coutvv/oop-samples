package ru.coutvv.oop.samples.iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ru.coutvv.oop.samples.iterator.menu.Menu;
import ru.coutvv.oop.samples.iterator.menu.MenuItem;

public class AliceWaitressImpl implements AliceWaitress {
	
	List<Menu> menus;

	public AliceWaitressImpl(Menu... menu) {
		super();
		this.menus = new ArrayList<Menu>();
		for(Menu m: menu) {
			menus.add(m);
		}
	}

	@Override
	public void printMenu() {
		System.out.println("<<ALL MENU>>");
		for(Menu menu : menus) {
			printMenu(menu);
		}
	}
	
	public void printMenu(String name) {
		Menu m = getMenu(name);
		if(m!=null) {
			printMenu(m);
		}
	}
	
	private void printMenu(Menu menu) {
		System.out.println(menu.getMenuName());
		printByIterator(menu.getOverIterator());
	}
	
	private Menu getMenu(String name) {
		for(Menu m: menus) { 
			if(m.getMenuName().equals(name)) return m;
		}
		return null;
	}
	
	private void printByIterator(Iterator<MenuItem> iter) {
		while(iter.hasNext()) {
			MenuItem mi = (MenuItem) iter.next();
			System.out.print(mi.getName() + ", ");
			System.out.print(mi.getPrice() + " -- ");
			System.out.println(mi.getDescription());
		}
	}


	@Override
	public boolean isItemVegetarian(String name) throws Exception {
		for(Menu menu : menus) {
			Iterator<MenuItem> iter = menu.getOverIterator();
			MenuItem mi = findMenuItemByName(iter, name);
			if(mi != null) return mi.isVegetarian();
		}
		throw new Exception("Нет такого блюда! По крайней мере сегодня");
	}
	
	public MenuItem findMenuItemByName(Iterator<MenuItem>  iter, String name) {
		while(iter.hasNext()) {
			MenuItem mi = (MenuItem) iter.next();
			if(mi.getName().equals(name))
				return mi;
		}
		return null;
	}

	@Override
	public void printBreakfastMenu() {
		printMenu("BREAKFAST MENU");
	}

	@Override
	public void printLunchMenu() {
		printMenu("LUNCH MENU");
	}
	

}
