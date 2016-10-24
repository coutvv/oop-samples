package ru.coutvv.oop.samples.templatemethod;

/**
 * Паттерн Шаблонный Метод задаёт "Скелет" алгоритма
 * в методе, оставляя определение реализации некоторых
 * шагов субклассам. Субклассы могут переопределять 
 * некоторые части алгоритма без изменения его структуры 
 * 
 * @author lomovtsevrs
 */
public abstract class CaffeineBeverage {
	public void boilWater() {
		System.out.println("BOiling water");
		
	}

	public void pourInCup() {
		System.out.println("Pouring into cup");
	}
	
	public boolean customerWantsCondiments() {
		return true;
	}
	
	public final void prepareRecipe() { 
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCondiments())
			addCondiments();
	}
	
	public abstract void brew();
	public abstract void addCondiments();
}
