package ru.coutvv.oop.samples.composer.menu;

import java.util.Iterator;

/**
 * Паттерн Компоновщик -- объединяет объекты в древовидные структуры 
 * для представления иерархий "часть/целое". Компоновщик позволяет
 * клиенту выполнять однородные операции с отдельными объектами и их
 * совокупностями 
 * 
 * @author lomovtsevrs
 */
public abstract class MenuComponent {


	protected String name;
	protected String description;
	protected double price;
	protected boolean vegetarian;
	
	public MenuComponent(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public abstract void print();
	
	public void add(MenuComponent mc) {
		throw new UnsupportedOperationException("Непозволительная операция");
	}
	
	public void remove(MenuComponent mc) {
		throw new UnsupportedOperationException("Непозволительная операция");
	}
	
	public MenuComponent getChild(int numChild) {
		throw new UnsupportedOperationException("Непозволительная операция");
	}
	

	public double getPrice() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Непозволительная операция");
	}
	
	public boolean isVegetarian() {
		throw new UnsupportedOperationException("Непозволительная операция");
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}
	
	public abstract Iterator<MenuComponent> createIterator();
}
