package ru.coutvv.oop.samples.singletone;

/**
 *	Паттерн Одиночка гарантирует, что класс имеет только 
 *	один экземпляр, и предоставляет глобальную точку доступа
 *  к этому экземпляру.
 * 
 * @author lomovtsevrs
 */
public class Alone {

	private static Alone foreverAlone = new Alone();;
	private Alone() {}
	
	public static Alone getInstance() {
		return foreverAlone;
	}
	
	
	public void doSomething() {
		System.out.println("this alone class with #" + this.hashCode());
	}
}
