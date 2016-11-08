package ru.coutvv.oop.samples.vice.cover.imgstate;

import java.awt.Component;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class ReadyState implements State{

	ImageIcon icon;
	
	public ReadyState(ImageIcon icon) throws IllegalArgumentException{
		if(icon == null) throw new IllegalArgumentException("Уебанскую иконку мне засадили");
		this.icon = icon;
	}

	@Override
	public int height() {
		return icon.getIconHeight();
	}

	@Override
	public int width() {
		return icon.getIconWidth();
	}

	@Override
	public void paint(Component c, Graphics g, int x, int y) {
		icon.paintIcon(c, g, x, y);
	}

}
