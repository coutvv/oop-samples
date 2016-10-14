package ru.coutvv.oop.samples.fabric;

import ru.coutvv.oop.samples.fabric.pizza.Pizza;
/**
 * Паттерн Фабричный Метод определяет интерфейс создания
 * объекта, но позволяет субклассам выбрать класс создаваемого
 * экземпляра. Таким образом, Фабричный Метод делегирует  
 * операцию создания экземпляра субклассам.
 * 
 * @author lomovtsevrs
 */
public abstract class PizzaStore {

	protected abstract Pizza createPizza(String type);
	
	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		return pizza;
	}
}
