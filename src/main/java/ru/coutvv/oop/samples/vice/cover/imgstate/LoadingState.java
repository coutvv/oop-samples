package ru.coutvv.oop.samples.vice.cover.imgstate;

import java.awt.Component;
import java.awt.Graphics;
import java.net.URL;

import javax.swing.ImageIcon;

import ru.coutvv.oop.samples.vice.cover.ImageProxy;

public class LoadingState implements State{
	
	ImageProxy imgProxy;
	URL imageURL;
	boolean retrieving = false;


	public LoadingState(ImageProxy img, URL imgURL) {
		this.imgProxy = img;
		this.imageURL = imgURL;
	}


	private final int HEIGHT = 600;
	private final int WIDTH = 800;
	
	@Override
	public int height() {
		return HEIGHT;
	}

	@Override
	public int width() {
		return WIDTH;
	}
	

	@Override
	public void paint(Component c, Graphics g, int x, int y) {
		g.drawString("Loading CD cover, please wait...", x+300, y+190);
		if(!retrieving) {
			retrieving = true;
			Thread retrievalThread = new Thread(new Runnable() {
				
				@Override
				public void run() {
					try {
						ImageIcon icon = new ImageIcon(imageURL, "CD Cover");
						imgProxy.setState(new ReadyState(icon));
						c.repaint();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			retrievalThread.start();
		}
		
	}

}
