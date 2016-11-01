package ru.coutvv.oop.samples.starcraft.unit;

import ru.coutvv.oop.samples.starcraft.unit.behavior.AIBehavior;
import ru.coutvv.oop.samples.starcraft.unit.behavior.HitBehavior;
import ru.coutvv.oop.samples.starcraft.unit.behavior.MoveBehavior;
/**
 * Паттерн Стратегия
 * @author lomovtsevrs
 *
 */
public abstract class Unit implements AIBehavior{

	//unit characteristics
	double x, y;
	double moveSpeed;
	double attackRange;
	double attackDamage;
	double health;
	
	public boolean isAlive = true;
	
	protected MoveBehavior moveBehavior;
	protected HitBehavior hitBehavior;
	
	public Unit(){
		
	}
	
	public Unit(HitBehavior hit, MoveBehavior move) {
		this.setHitBehavior(hit);
		this.setMoveBehavior(move);
	}
	
	
	public void move(double x, double y) {
		moveBehavior.move(this, x, y);
	}
	
	public void frameMove(double x, double y) {
		moveBehavior.moveByFrame(this, x, y);
	}
	
	public void hit(Unit unit) {
		hitBehavior.hit(this, unit);
	}
	
	public void damage(double points) {
		this.health -= points;
		if(health <= 0) {
			die();
		}
	}
	
	public void die() {
		isAlive = false;
		System.out.println("Unit " + this.getClass() + " died");
	}
	
	public abstract void display();
	

	
	public MoveBehavior getMoveBehavior() {
		return moveBehavior;
	}

	public void setMoveBehavior(MoveBehavior moveBehavior) {
		this.moveBehavior = moveBehavior;
	}

	public HitBehavior getHitBehavior() {
		return hitBehavior;
	}

	public void setHitBehavior(HitBehavior hitBehavior) {
		this.hitBehavior = hitBehavior;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getMoveSpeed() {
		return moveSpeed;
	}

	public void setMoveSpeed(double moveSpeed) {
		this.moveSpeed = moveSpeed;
	}

	public double getAttackRange() {
		return attackRange;
	}

	public void setAttackRange(double attackRange) {
		this.attackRange = attackRange;
	}

	public double getAttackDamage() {
		return attackDamage;
	}

	public void setAttackDamage(double attackDamage) {
		this.attackDamage = attackDamage;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
	}

	/** по умолчанию действия ИИ */
	public void enemyNear(double x, double y) {
		//ничего не делаем
	}
	
}
