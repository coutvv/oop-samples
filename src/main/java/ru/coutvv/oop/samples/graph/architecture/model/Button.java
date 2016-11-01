package ru.coutvv.oop.samples.graph.architecture.model;

import ru.coutvv.oop.samples.graph.architecture.DrawableObject;

public class Button implements DrawableObject {
	
	public Button(double x, double y, int height, int width, int textureId) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.textureId = textureId;
	}

	private double x, y;
	
	private int height, width;
	
	private int textureId;
	


	public double getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
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
