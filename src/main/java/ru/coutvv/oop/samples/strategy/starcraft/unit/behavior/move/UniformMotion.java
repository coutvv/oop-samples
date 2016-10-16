package ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.move;

import ru.coutvv.oop.samples.strategy.starcraft.unit.Unit;
import ru.coutvv.oop.samples.strategy.starcraft.unit.behavior.MoveBehavior;

/**
 * Равномерное движение
 * @author coutvv
 *
 */
public class UniformMotion implements MoveBehavior {

	private long period = 1000; ///1 sec for period
	
	public void move(Unit unit, double x, double y) {
		double unitSpeed = unit.getMoveSpeed();
		double doDist = 0;
		double distance = Math.sqrt((x-unit.getX())*(x-unit.getX()) + (y-unit.getY())*(y-unit.getY()));
		while(doDist < distance) {
			 //там теорема синусов вычисляющая какую то херь, мне лень поэтому просто
			doDist += unitSpeed;
			System.out.println(unit.getClass() + " прошёл " + doDist);
			try {
				Thread.sleep(period);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
