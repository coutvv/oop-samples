package ru.coutvv.oop.samples.adapter;

/**
 * Паттерн Адаптер преобразует интерфейс класса к другому
 * интерфейсу, на который рассчитан клиент. Адаптер обеспечивает
 * совместную работу классов, невозможную в обычных условиях
 * из-за несовместимости интерфейсов. 
 * 
 * @author lomovtsevrs
 *
 */
public class DuckAdapter implements Turkey{

	Duck duck;
	public DuckAdapter(Duck duck) {
		this.duck = duck;
	}
	
	public void gobble() {
		duck.quack();
	}

	public void fly() {
		duck.fly();
	}
	
}
