package ru.coutvv.oop.samples.iterator.menu;

import java.util.Iterator;

public abstract class AbstractMenu implements Menu {
	
	String menuName;
	
	public AbstractMenu(String menuName) {
		this.menuName = menuName;
	}
	
	public String getMenuName() {
		return menuName;
	}
	
	private AbstractMenu subMenu;
	
	public void setSubMenu(AbstractMenu sMenu) {
		this.subMenu = sMenu;
	}
	
	public OverIterator getOverIterator() {
		OverIterator result = new OverIterator();
		if(subMenu != null) {
			result.addIterator(subMenu.createIterator());
		}
		result.addIterator(this.createIterator());
		return result;
		
	}
	
}
