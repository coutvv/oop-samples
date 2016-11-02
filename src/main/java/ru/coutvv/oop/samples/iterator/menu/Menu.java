package ru.coutvv.oop.samples.iterator.menu;

import java.util.Iterator;

public interface Menu {
	String getMenuName();
	Iterator<MenuItem> createIterator();
	OverIterator getOverIterator();
}
