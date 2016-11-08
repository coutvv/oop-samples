package ru.coutvv.oop.samples.test.vice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ru.coutvv.oop.samples.vice.cover.ImageProxy;

public class ImageProxyTestDrive {
	
	
	public static void main(String[] args) {
		try {
			new ImageProxyTestDrive().test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void test() throws MalformedURLException {
		URL initialURL = new URL("http://blogs-images.forbes.com/insertcoin/files/2016/11/blizzcon-sombra.jpg?width=960");
		icon = new ImageProxy(initialURL);
		start();
	}
	
	Icon icon;
	JFrame frame;
	
	public void start() {
		frame = new JFrame("title");
		frame.setSize(800, 600);
		JButton button = new JButton("Should I do it? ");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				button.setVisible(false);
				JLabel lbl = new JLabel(icon);
				frame.add(lbl);
			}
		});
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setVisible(true);//this create window bleat'
		System.out.println("the end");
		
	}
}
