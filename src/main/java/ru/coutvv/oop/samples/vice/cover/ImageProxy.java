package ru.coutvv.oop.samples.vice.cover;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.Icon;

import ru.coutvv.oop.samples.vice.cover.imgstate.LoadingState;
import ru.coutvv.oop.samples.vice.cover.imgstate.State;

public class ImageProxy implements Icon {
	
	private State state;
	
	public ImageProxy(URL url) {
		state = new LoadingState(this, url);
	}

	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		state.paint(c, g, x, y);
	}

	@Override
	public int getIconWidth() {
		return state.width();
	}

	@Override
	public int getIconHeight() {
		return state.height();
	}
	
	
	public void setState(State state){
		this.state = state;
	}
}
