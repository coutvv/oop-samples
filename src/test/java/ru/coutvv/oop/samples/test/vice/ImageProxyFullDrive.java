package ru.coutvv.oop.samples.test.vice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ru.coutvv.oop.samples.vice.cover.ImageProxy;

/**
 * Прожка для демострации виртуального заместителя
 * на примере обложек и то такое
 * 
 * @author lomovtsevrs
 */
public class ImageProxyFullDrive {

	JFrame frame = new JFrame("CD Cover Viewer"); 
	JLabel lbl = new JLabel();
	JMenuBar menuBar;
	JMenu menu;
	
	Map<String, String> cds = new HashMap<>();
	
	public ImageProxyFullDrive() throws MalformedURLException {
		createDB();
		URL init = new URL(cds.get("Rammstein"));
		
		menuBar  =new JMenuBar();
		menu = new JMenu("Fav's cds");
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);
		for(String key : cds.keySet()) {
			JMenuItem item = new JMenuItem(key);
			item.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					try {
						lbl.setIcon(new ImageProxy(new URL(cds.get(key))));
						frame.repaint();
					} catch (MalformedURLException e1) {
						e1.printStackTrace();
					}
				}
			});
			menu.add(item);
		}
		lbl.setIcon(new ImageProxy(init));
		frame.getContentPane().add(lbl);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setVisible(true);
	}
	
	private void createDB() {
		addRecord("Rammstein", "http://voda-mag.com/wp-content/uploads/2016/03/rammstein_header_by_stainless_heart-d60f286.png");
		addRecord("Nevermind", "http://vinylrecords.com.ua/image/data/covers/nevermind.jpg");
		addRecord("Black Album", "https://upload.wikimedia.org/wikipedia/ru/c/c2/Metallica_Album.jpg");
		addRecord("Piece of Mind", "http://img2-ak.lst.fm/i/u/300x300/c796e87535ef4164a3fade9d16ba99f7.jpg");
	}
	private void addRecord(String name, String link) {
		cds.put(name, link);
	}
	
	public static void main(String[] args) throws MalformedURLException {
		new ImageProxyFullDrive();
	}
}
