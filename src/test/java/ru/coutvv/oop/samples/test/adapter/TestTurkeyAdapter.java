package ru.coutvv.oop.samples.test.adapter;

import org.junit.Test;

import ru.coutvv.oop.samples.adapter.Duck;
import ru.coutvv.oop.samples.adapter.MallarDuck;
import ru.coutvv.oop.samples.adapter.Turkey;
import ru.coutvv.oop.samples.adapter.TurkeyAdapter;
import ru.coutvv.oop.samples.adapter.WildTurkey;

public class TestTurkeyAdapter {

	@Test
	public void test() {
		Duck d = new MallarDuck();
		Turkey t = new WildTurkey();
		Duck adT = new TurkeyAdapter(t);
		testDuck(d);
		testDuck(adT);
	}
	
	private void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}
