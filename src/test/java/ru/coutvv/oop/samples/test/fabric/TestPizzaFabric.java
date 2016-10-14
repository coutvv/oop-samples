package ru.coutvv.oop.samples.test.fabric;

import ru.coutvv.oop.samples.fabric.ChicagoPizzaStore;
import ru.coutvv.oop.samples.fabric.NYStylePizzaStore;
import ru.coutvv.oop.samples.fabric.PizzaStore;
import ru.coutvv.oop.samples.fabric.pizza.Pizza;

public class TestPizzaFabric {
	public static void main(String[] args) {
		PizzaStore nyStore = new NYStylePizzaStore();
		PizzaStore chStore = new ChicagoPizzaStore();
		Pizza pizza = nyStore.orderPizza("cheese");
		
		pizza = nyStore.orderPizza("pepper");
		pizza = chStore.orderPizza("cheese");
		pizza = chStore.orderPizza("pepper");
	}
}
