package ru.coutvv.oop.samples.graph.architecture.model;

import ru.coutvv.oop.samples.graph.architecture.DrawableObject;
import ru.coutvv.oop.samples.starcraft.unit.Unit;

/**
 * Внезапно адаптер, лiл
 * @author lomovtsevrs
 *
 */
public class DrawableUnit implements DrawableObject{
	
	private Unit unit;
	
	private int height; 
	private int width; 
	private int textureId;
	
	public DrawableUnit(Unit unit, int height, int width, int textureId) {
		this.unit = unit;
		this.height= height;
		this.width = width;
		this.textureId = textureId;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getTextureId() {
		return textureId;
	}
	public void setTextureId(int textureId) {
		this.textureId = textureId;
	}

	@Override
	public double getX() {
		return unit.getX();
	}

	@Override
	public double getY() {
		return unit.getY();
	}
}
