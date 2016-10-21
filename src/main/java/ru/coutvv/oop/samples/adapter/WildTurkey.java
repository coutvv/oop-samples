package ru.coutvv.oop.samples.adapter;

public class WildTurkey implements Turkey {

	public void gobble() {
		System.out.println("Gooble!");
	}

	public void fly() {
		System.out.println("fly to short distantion");
	}

}
