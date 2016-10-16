package ru.coutvv.oop.samples.strategy;

import ru.coutvv.oop.samples.strategy.superduck.QuackBehavior;
import ru.coutvv.oop.samples.strategy.superduck.behavior.JustQuack;

/**
 * this simudock package demonstrate pattern Strategy!
 * 
 *  Паттерн Стратегия определяет семейство алгоритмов, инкапсулирует
 *  каждый из них и обеспечивает их взаимозаменяемость. Он позволяет
 *  модифицировать алгоритмы независимо от их использования на стороне
 *  клиента
 * 
 * 
 * это класс манка уток. херня, неважно
 * 
 * @author lomovtsevrs
 *
 */
public class DuckManok {

	QuackBehavior quackBehavior = new JustQuack();
	
	public void performQuack() {
		quackBehavior.quack();
	}
}
