package ru.coutvv.oop.samples.test.singletone;

import org.junit.Test;

import ru.coutvv.oop.samples.singletone.Alone;

public class TestSingletone {
	
	@Test
	public void test() {
		Alone alone = Alone.getInstance();
		alone.doSomething();
	}
	
	@Test
	public void anotherTest() {
		Alone alone = Alone.getInstance();
		alone.doSomething();
	}
}
