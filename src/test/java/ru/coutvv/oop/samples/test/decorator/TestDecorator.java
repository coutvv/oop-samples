package ru.coutvv.oop.samples.test.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

import junit.framework.TestCase;
import ru.coutvv.oop.samples.decorator.Beverage;
import ru.coutvv.oop.samples.decorator.DarkRoast;
import ru.coutvv.oop.samples.decorator.Espresso;
import ru.coutvv.oop.samples.decorator.HouseBlend;
import ru.coutvv.oop.samples.decorator.iodecorator.LowerCaseInputStream;
import ru.coutvv.oop.samples.decorator.myown.mixes.Mocha;
import ru.coutvv.oop.samples.decorator.myown.mixes.SmallPortion;
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
		
		hb = new SmallPortion(hb);
		System.out.println(hb.getDescription() + " $ " + hb.cost());
	}
	
	public void testInput() {
		
		try {
			InputStream in = new LowerCaseInputStream(
									new BufferedInputStream(
											new FileInputStream("src/main/resources/testIODecorator.txt")
											)
							);
			int c; 
			while((c = in.read()) >= 0 ) {
				System.out.print((char) c);
			} System.out.println();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
