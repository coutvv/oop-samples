package ru.coutvv.oop.samples.starcraft.unit.behavior.move;

import ru.coutvv.oop.samples.starcraft.unit.Unit;
import ru.coutvv.oop.samples.starcraft.unit.behavior.MoveBehavior;

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
			System.out.println("Юнит с хэшом #" + unit.hashCode() + " прошёл " + doDist);
			try {
				Thread.sleep(period);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void moveByFrame(Unit unit, double x, double y) {
		double ddistance = unit.getMoveSpeed();
		double a = unit.getX(),
			   b = unit.getY();
		double distance = Math.sqrt((x-unit.getX())*(x-unit.getX()) + (y-unit.getY())*(y-unit.getY()));
		double sin = (y-b)/distance,
			   cos = (x-a)/distance;
		
		double dx = ddistance * sin,
			   dy = ddistance * cos;
		
		unit.setX(unit.getX() + dx);
		unit.setY(unit.getY() + dy);
	}

}
