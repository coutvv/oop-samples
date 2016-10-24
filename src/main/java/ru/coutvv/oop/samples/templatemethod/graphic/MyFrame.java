package ru.coutvv.oop.samples.templatemethod.graphic;

import java.awt.Graphics;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyFrame(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.setVisible(true);
	}
	
	public void paint(Graphics graphics) {
		super.paint(graphics);
		String msg = "Shut up!";
		graphics.drawString(msg, 100, 100);
	}
}