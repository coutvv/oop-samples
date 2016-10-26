package ru.coutvv.oop.samples.graph.architecture.model;

import ru.coutvv.oop.samples.graph.architecture.DrawableObject;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Probe;

public class DrawableProbe extends Probe implements DrawableObject{
	
	int height, width;
	int textureId;
	
	public DrawableProbe(double x, double y, int width, int height, int textureId) {
		this.height = height;
		this.width = width;
		this.setX(x);
		this.setY(y);
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
}
