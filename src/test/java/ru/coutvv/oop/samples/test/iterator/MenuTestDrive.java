package ru.coutvv.oop.samples.test.iterator;

import org.junit.Test;

import ru.coutvv.oop.samples.iterator.AliceWaitress;
import ru.coutvv.oop.samples.iterator.AliceWaitressImpl;
import ru.coutvv.oop.samples.iterator.menu.CafeMenu;
import ru.coutvv.oop.samples.iterator.menu.DesertSubMenu;
import ru.coutvv.oop.samples.iterator.menu.DinerMenu;
import ru.coutvv.oop.samples.iterator.menu.PancakeHouseMenu;

public class MenuTestDrive {

	@Test
	public void test() throws Exception {
		PancakeHouseMenu phm = new PancakeHouseMenu();
		DinerMenu dm = new DinerMenu();
		CafeMenu cm = new CafeMenu();
		cm.setSubMenu(new DesertSubMenu());
		AliceWaitress aw = new AliceWaitressImpl(phm, dm, cm);
		aw.printMenu();
		System.out.println(aw.isItemVegetarian("Vegetarian BLT"));
		
	}
}
