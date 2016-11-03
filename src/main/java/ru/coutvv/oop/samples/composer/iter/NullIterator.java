package ru.coutvv.oop.samples.composer.iter;

import java.util.Iterator;

import ru.coutvv.oop.samples.composer.menu.MenuComponent;

public class NullIterator implements Iterator<MenuComponent> {

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public MenuComponent next() {
		throw new UnsupportedOperationException("Непозволительная операция!");
	}

	
}
