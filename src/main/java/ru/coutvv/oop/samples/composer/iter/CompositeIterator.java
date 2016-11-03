package ru.coutvv.oop.samples.composer.iter;

import java.util.Iterator;
import java.util.Stack;

import ru.coutvv.oop.samples.composer.menu.Menu;
import ru.coutvv.oop.samples.composer.menu.MenuComponent;

public class CompositeIterator implements Iterator<MenuComponent>{

	Stack<Iterator<MenuComponent>> stack = new Stack<>();
	
	public CompositeIterator(Iterator<MenuComponent> iter) {
		stack.push(iter);
	}
	@Override
	public boolean hasNext() {
		if(stack.isEmpty()) {
			return false;
		} else {
			Iterator<MenuComponent> iter = stack.peek();
			if(!iter.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

	@Override
	public MenuComponent next() {
		if(hasNext()) {
			Iterator<MenuComponent> iter= stack.peek();
			MenuComponent mc = iter.next();
			if(mc instanceof Menu) {
				stack.push(mc.createIterator());
			}
			return mc;
		}
		return null;
	}

}
