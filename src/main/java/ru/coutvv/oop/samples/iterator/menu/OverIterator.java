package ru.coutvv.oop.samples.iterator.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * Паттерн Итератор -- предоставляет механизм
 * последовательного перебора элементов коллекции
 * без раскрытия её внутреннего представления.
 *  
 * @author lomovtsevrs
 */
public class OverIterator implements Iterator {
	
	@Override
	public boolean hasNext() {
		if(iterPosition < iters.size()) {
			if(iters.get(iterPosition).hasNext()) {
				return true;
			} else {
				iterPosition++;
				return hasNext();
			}
		}
		return false;
	}

	@Override
	public Object next() {
		if(iters.get(iterPosition).hasNext()) {
			return iters.get(iterPosition).next();
		}
		return null;
	}

	List<Iterator> iters;
	int iterPosition;
	
	public OverIterator() {
		iters = new ArrayList<>();
		iterPosition = 0;
	}

	public void addIterator(Iterator iter) {
		iters.add(iter);
	}
	
	
}
