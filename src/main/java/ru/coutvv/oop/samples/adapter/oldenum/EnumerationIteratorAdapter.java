package ru.coutvv.oop.samples.adapter.oldenum;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationIteratorAdapter implements Iterator {

	
	Enumeration enumeration;
	
	
	
	public EnumerationIteratorAdapter(Enumeration e) {
		enumeration = e;
	}
	public boolean hasNext() {
		return enumeration.hasMoreElements();
	}

	public Object next() {
		return enumeration.nextElement();
	}
	
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
