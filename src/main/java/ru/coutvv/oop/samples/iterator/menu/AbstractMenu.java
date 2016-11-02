package ru.coutvv.oop.samples.iterator.menu;

public abstract class AbstractMenu implements Menu {
	String menuName;
	public AbstractMenu(String menuName) {
		this.menuName = menuName;
	}
	public String getMenuName() {
		return menuName;
	}
	
}
