package ru.coutvv.oop.samples.composer.menu;

import java.util.Iterator;

import ru.coutvv.oop.samples.composer.iter.NullIterator;

public class MenuItem extends MenuComponent {

	public MenuItem(String name, String description, double price, boolean isVegetarian) {
		super(name,description);
		this.price = price;
		this.vegetarian = isVegetarian;
	}

	@Override
	public void print() {
		System.out.print(this.getName() + ", ");
		System.out.print(this.getPrice() + " -- ");
		System.out.println(this.getDescription());
	}
	

	public double getPrice() {
		return price;
	}
	
	@Override
	public Iterator<MenuComponent> createIterator() {
		return new NullIterator();
	}

	public boolean isVegetarian() {
		return vegetarian;
	}
}
