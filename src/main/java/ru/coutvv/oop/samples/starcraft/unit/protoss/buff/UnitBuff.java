package ru.coutvv.oop.samples.starcraft.unit.protoss.buff;

import ru.coutvv.oop.samples.starcraft.unit.Unit;
/**
 * Паттерн декоратор динамически наделяет объект новыми 
 * возможностями и является гибкой альтернативой субклассирования
 * в области расширения функциональности.
 * 
 * @author lomovtsevrs
 */
public abstract class UnitBuff extends Unit {

	protected Unit unit;
	
	public UnitBuff(Unit unit) {
		super();
		this.unit = unit;
	}
	
	public void move(double x, double y) {
		unit.move(x, y);
	}
	
	public void hit(Unit unit) {
		this.unit.hit(unit);
	}

	public abstract void damage(double points);
	
	public final Unit getUnit() {
		return unit;
	}
}
