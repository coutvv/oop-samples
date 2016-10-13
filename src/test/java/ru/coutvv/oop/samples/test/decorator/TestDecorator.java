package ru.coutvv.oop.samples.test.decorator;

import junit.framework.TestCase;
import ru.coutvv.oop.samples.decorator.Beverage;
import ru.coutvv.oop.samples.decorator.DarkRoast;
import ru.coutvv.oop.samples.decorator.Espresso;
import ru.coutvv.oop.samples.decorator.HouseBlend;
import ru.coutvv.oop.samples.decorator.myown.mixes.Mocha;
import ru.coutvv.oop.samples.decorator.myown.mixes.Soy;
import ru.coutvv.oop.samples.decorator.myown.mixes.Whip;
/**
 * Паттерн Декоратор динамически наделяет объект новыми
 * возможностями и является гибкой альтернативой субклассированию
 * в области расширения функциональности
 * 
 * @author lomovtsevrs
 *
 */
public class TestDecorator extends TestCase{

	public void test() {
		Beverage bev = new Espresso();
		System.out.println(bev.getDescription() + " $ " + bev.cost());
		Beverage dr  =new DarkRoast();
		dr = new Mocha(dr);
		dr = new Whip(dr);
		System.out.println(dr.getDescription() + " $ " + dr.cost());
		
		Beverage hb = new HouseBlend();
		hb = new Soy(hb);
		hb = new Mocha(hb);
		hb = new Whip(hb);
		System.out.println(hb.getDescription() + " $ " + hb.cost());
	}
}
