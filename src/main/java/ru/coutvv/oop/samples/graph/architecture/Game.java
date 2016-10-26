package ru.coutvv.oop.samples.graph.architecture;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import java.util.ArrayList;
import java.util.List;

import ru.coutvv.oop.samples.graph.architecture.model.DrawableProbe;

/**
 * Синглтон игры
 * 
 * @author lomovtsevrs
 */
public class Game {

	private static Game instance = new Game();
	
	private Screen screen;
	private Game() {
		screen = new Screen();
		long window = screen.init();
		//вынести в фабрику?
		int probeTexture = screen.loadTexture("src/main/resources/probe.png");
		obj = new DrawableProbe(200,100, 400,400, probeTexture);
		objs.add(obj);
		objs.add(new DrawableProbe(50, 25, 50, 50, probeTexture));
		loop(window);
		
	}
	
	private List<DrawableObject> objs = new ArrayList<>();
	
	DrawableProbe obj;

	public void loop(long window) {
		while(!glfwWindowShouldClose(window)) {
			glfwSwapBuffers(window);
			for(DrawableObject obj : objs) {
				screen.draw(obj);
			}
			glfwPollEvents();
			try {
				obj.setX(obj.getX() + 15);
				Thread.sleep(1000);
				System.out.println(objs.size());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static Game getInstance() { 
		return instance;
	}
	
	public static void main(String[] args) {
		Game.getInstance();
	}
}
