package ru.coutvv.oop.samples.decorator;

public abstract class Beverage {

	protected double cost;
	
	public double getCost(){
		return mixin == null ? cost : cost + mixin.getCost();
	}
	
	
	protected String description;
	
	public String getDescription() {
		return mixin == null ? description : mixin.getDescription() + " with " + description;
	}
	
	public Beverage mixin;
	
	public void setMixin(Beverage bev) {
		mixin = bev;
	}
}
