package ru.coutvv.oop.samples.graph.architecture.model;

import ru.coutvv.oop.samples.graph.architecture.DrawableObject;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Probe;

/**
 * Внезапно адаптер, лiл
 * @author lomovtsevrs
 *
 */
public class DrawableProbe implements DrawableObject{
	
	private Probe probe;
	
	private int height; 
	private int width; 
	private int textureId;
	
	public DrawableProbe(Probe probe, int height, int width, int textureId) {
		this.probe = probe;
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
		return probe.getX();
	}

	@Override
	public double getY() {
		return probe.getY();
	}
}
