package ru.coutvv.oop.samples.vice.cover.imgstate;

import java.awt.Component;
import java.awt.Graphics;


/**
 * Состояние картинки(по умолчанию загружается)
 * 
 * @author lomovtsevrs
 */
public interface State {

	int height();
	
	int width();
	
	void paint(Component c, Graphics g, int x, int y);
	
}
