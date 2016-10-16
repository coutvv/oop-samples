package ru.coutvv.oop.samples.sumuduck.superduck;

/**
 * Абстрактный класс утки
 * @author lomovtsevrs
 *
 */
public abstract class Duck {

	protected FlyBehavior flyBehavior;
	protected QuackBehavior quackBehavior;

	public void display(){
		System.out.println("display someone duck");
	}
	
	public void swim() {
		System.out.println("all ducks can swimming");
	}
	
	public void performFly() {
		this.flyBehavior.fly();
	}
	
	public void performQuack() {
		this.quackBehavior.quack();
	}


	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}
	
	
}
