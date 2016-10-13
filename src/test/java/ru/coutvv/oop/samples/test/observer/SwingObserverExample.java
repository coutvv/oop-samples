package ru.coutvv.oop.samples.test.observer;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class SwingObserverExample {
	JFrame frame ;
	
	public static void main(String[] args) {
		SwingObserverExample ex = new SwingObserverExample();
		ex.start();
	}
	
	public void start() {
		frame = new JFrame("title");
		frame.setSize(200, 200);
		JButton button = new JButton("Should I do it? ");
		button.addActionListener(new AngelListener());
		button.addActionListener(new DevilListener());
		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setVisible(true);//this create window bleat'
		System.out.println("the end");
	}
	
	
}

class AngelListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("Dont\'t do it, you might regret it!");
	}
	
}

class DevilListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		System.out.println("Come on, do it!");
	}
	
}
