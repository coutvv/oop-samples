package ru.coutvv.oop.samples.composer.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ru.coutvv.oop.samples.composer.iter.CompositeIterator;

public class Menu extends MenuComponent{

	private List<MenuComponent> childs;

	public Menu(String name, String description) {
		super(name, description);
		childs = new ArrayList<>();
	}

	@Override
	public void print() {
		System.out.print("[ Menu: ");
		System.out.println(this.getName() + " ]");
		System.out.println("[ " + this.getDescription() + " ] Блюда:");
		Iterator<MenuComponent> iter = childs.iterator();
		while(iter.hasNext()) {
			iter.next().print();
		}
	}

	Iterator<MenuComponent> iter = null;
	
	@Override
	public Iterator<MenuComponent> createIterator() {
		if(iter == null) {
			iter = new CompositeIterator(childs.iterator());
		}
		return iter;
	}

	@Override
	public void add(MenuComponent mc) {
		childs.add(mc);
	}

	@Override
	public void remove(MenuComponent mc) {
		childs.remove(mc);
	}

	@Override
	public MenuComponent getChild(int numChild) {
		if(numChild < childs.size()) {
			return childs.get(0);
		}
		return null;
	}

}
