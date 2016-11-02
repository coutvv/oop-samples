package ru.coutvv.oop.samples.iterator.menu;

import java.util.Calendar;
import java.util.Iterator;

public class AlternatingDinerMenuIterator implements Iterator<MenuItem>{

	private MenuItem[] menuItems;
	private int position;
	Calendar rightNow;
	public AlternatingDinerMenuIterator(MenuItem[] items) {
		this.menuItems = items;
		rightNow = Calendar.getInstance();
		position = rightNow.get(Calendar.DAY_OF_WEEK) % 2;
	}
	
	@Override
	public boolean hasNext() {
		if(position < menuItems.length && menuItems[position] != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public MenuItem next() {
		if(hasNext()) {
			MenuItem result =menuItems[position];
			position += 2;
			return  result;
		}
		return null;
	}

}
