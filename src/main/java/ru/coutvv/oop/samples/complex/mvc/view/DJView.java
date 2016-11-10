package ru.coutvv.oop.samples.complex.mvc.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ru.coutvv.oop.samples.complex.mvc.ctrlr.ControllerInterface;
import ru.coutvv.oop.samples.complex.mvc.model.BeatModelInterface;
import ru.coutvv.oop.samples.complex.mvc.obs.BPMObserver;
import ru.coutvv.oop.samples.complex.mvc.obs.BeatObserver;
import ru.coutvv.oop.samples.complex.mvc.view.element.BeatBar;

public class DJView implements ActionListener, BeatObserver, BPMObserver {
	
	BeatModelInterface model;
	ControllerInterface controller;
	
	JFrame viewFrame;
	JPanel viewPanel;
	
	BeatBar beatBar;
	JLabel bpmOutputLabel;
	
	
	public DJView(ControllerInterface controller, BeatModelInterface model) {
		this.controller = controller;
		this.model = model;
		model.registerObserver((BeatObserver)this);
		model.registerObsever((BPMObserver)this);
	}
	
	public void createView() {
		viewFrame = new JFrame("DJView");
		setupFrame(viewFrame);
		viewPanel = new JPanel();
		beatBar = new BeatBar();
		bpmOutputLabel = new JLabel("Beat per minute: " + model.getBPM());
		viewPanel.add(BorderLayout.CENTER, bpmOutputLabel);
		viewPanel.add(BorderLayout.CENTER, beatBar);
		viewFrame.getContentPane().add(BorderLayout.CENTER,viewPanel);
	}
	
	int x = 300, y = 400;
	
	private void setupFrame(JFrame frame) {
		frame.setSize(400, 300);
		frame.setLocation(x, y);
		x += 100;
		y += 100;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().add(BorderLayout.CENTER, button);
		frame.setVisible(true);//this create window bleat'
	}
	
	
	public void updateBeat() {
		beatBar.setValue(100);
	}
	
	JLabel bpmLabel = new JLabel("test");
	JTextField bpmTextField = new JTextField(10);
	JButton setBPMButton = new JButton("set");
	JButton increaseBPMButton = new JButton(">>");
	JButton decreaseBPMButton = new JButton("<<");
	JMenuBar menuBar = new JMenuBar();
	JMenu menu = new JMenu("menu");
	JMenuItem startMenuItem = new JMenuItem("start");
	JMenuItem stopMenuItem = new JMenuItem("stop");
	
	public void createControls() {
		JFrame addon = new JFrame("DJ Control");
		setupFrame(addon);
		startMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.start();
			}
		});
		menu.add(startMenuItem);
		stopMenuItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.stop();
			}
		});
		menu.add(stopMenuItem);
		menuBar.add(menu);
//		addon.getContentPane().add(menuBar);
		JPanel panel = new JPanel();
		panel.add(BorderLayout.CENTER, bpmLabel);
		panel.add(BorderLayout.CENTER, bpmTextField);
		panel.add(BorderLayout.CENTER, setBPMButton);
		panel.add(BorderLayout.CENTER, increaseBPMButton);
		panel.add(BorderLayout.CENTER, decreaseBPMButton);
		addon.setJMenuBar(menuBar);
		addon.getContentPane().add(panel);
		createActionListener();
	}
	
	public void createActionListener() {
		setBPMButton.addActionListener(this);
		increaseBPMButton.addActionListener(this);
		decreaseBPMButton.addActionListener(this);
	}
	
	public void enableStopMenuItem() {
		stopMenuItem.setEnabled(true);
	}
	
	public void disableStopMenuItem() {
		stopMenuItem.setEnabled(false);
	}
	
	public void enableStartMenuItem() {
		startMenuItem.setEnabled(true);
	}
	
	public void disableStartMenuItem() {
		startMenuItem.setEnabled(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == setBPMButton && !bpmTextField.getText().equals("")) {
			int bpm = Integer.parseInt(bpmTextField.getText());
			System.out.println("set");
			controller.setBPM(bpm);
			
		} else if(e.getSource() == increaseBPMButton) {
			controller.increaseBPM();
		} else if(e.getSource() == decreaseBPMButton) {
			controller.decreaseBPM();
		}
	}

	@Override
	public void update() {
		beatBar.setValue(100);
		
		int bpm = model.getBPM();
		if(bpm == 0) {
			bpmOutputLabel.setText("offline");
		} else {
			bpmOutputLabel.setText("Current BPM : " + bpm);
		}
	}

}
