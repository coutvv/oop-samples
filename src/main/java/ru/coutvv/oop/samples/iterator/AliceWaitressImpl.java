package ru.coutvv.oop.samples.iterator;

public class AliceWaitressImpl implements AliceWaitress {
	
	PancakeHouseMenu pancakeHouseMenu;
	DinerMenu dinerMenu;

	public AliceWaitressImpl(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		super();
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
	}

	@Override
	public void printMenu() {
		System.out.println("<<ALL MENU>>");
		printBreakfastMenu();
		printLunchMenu();
	}
	
	private void printByIterator(Iterator iter) {
		while(iter.hasNext()) {
			MenuItem mi = (MenuItem) iter.next();
			System.out.print(mi.getName() + ", ");
			System.out.print(mi.getPrice() + " -- ");
			System.out.println(mi.getDescription());
		}
	}

	@Override
	public void printBreakfastMenu() {
		System.out.println("BREAKFAST");
		Iterator pankIter = pancakeHouseMenu.createIterator();
		printByIterator(pankIter);
	}

	@Override
	public void printLunchMenu() {
		Iterator dinIter = dinerMenu.createIterator();
		System.out.println("LUNCH");
		printByIterator(dinIter);
	}

	@Override
	public boolean isItemVegetarian(String name) {
		Iterator pankIter = pancakeHouseMenu.createIterator();
		Iterator dinIter = dinerMenu.createIterator();
		MenuItem res = findByName(pankIter, name);
		if(res == null) {
			res = findByName(dinIter, name);
		}
		return res.isVegetarian();
	}
	
	public MenuItem findByName(Iterator iter, String name) {
		while(iter.hasNext()) {
			MenuItem mi = (MenuItem) iter.next();
			if(mi.name.equals(name))
				return mi;
		}
		return null;
	}

}
