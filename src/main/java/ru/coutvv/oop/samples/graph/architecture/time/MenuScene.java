package ru.coutvv.oop.samples.graph.architecture.time;

import java.util.ArrayList;
import java.util.List;

import ru.coutvv.oop.samples.graph.architecture.DrawableObject;
import ru.coutvv.oop.samples.graph.architecture.model.Button;

public class MenuScene implements Scene {
	
	private List<DrawableObject> objs;
	
	public MenuScene(int buttonTexture) {
		objs = new ArrayList<>();
		Button button1 = new Button(100, 350, 200, 400, buttonTexture);
		objs.add(button1);
	}

	@Override
	public List<DrawableObject> getObjects() {
		
		return objs;
	}

	@Override
	public void turnAround() {
		// TODO Auto-generated method stub
		
	}

}
