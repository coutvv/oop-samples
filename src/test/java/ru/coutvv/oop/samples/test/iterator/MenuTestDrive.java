package ru.coutvv.oop.samples.test.iterator;

import org.junit.Test;

import ru.coutvv.oop.samples.iterator.AliceWaitress;
import ru.coutvv.oop.samples.iterator.AliceWaitressImpl;
import ru.coutvv.oop.samples.iterator.DinerMenu;
import ru.coutvv.oop.samples.iterator.PancakeHouseMenu;

public class MenuTestDrive {

	@Test
	public void test() {
		PancakeHouseMenu phm = new PancakeHouseMenu();
		DinerMenu dm = new DinerMenu();
		AliceWaitress aw = new AliceWaitressImpl(phm, dm);
		aw.printMenu();
		System.out.println(aw.isItemVegetarian("Vegetarian BLT"));
		
	}
}
