package ru.coutvv.oop.samples.graph.architecture;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import java.util.ArrayList;
import java.util.List;

import ru.coutvv.oop.samples.graph.architecture.model.DrawableUnit;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Probe;

/**
 * Синглтон игры
 * 
 * @author lomovtsevrs
 */
public class Game {

	private static Game instance = new Game();
	
	private Screen screen;
	private Probe probe1, probe2;
	private Game() {
		screen = new Screen();
		long window = screen.init();
		//вынести в фабрику?
		int probeTexture = screen.loadTexture("src/main/resources/probe.png");
		probe1 = new Probe();
		probe2 = new Probe();
		obj = new DrawableUnit(probe1, 400,400, probeTexture);
		objs.add(obj);
		objs.add(new DrawableUnit(probe2, 50, 50, probeTexture));
		loop(window);
		
	}
	
	private List<DrawableObject> objs = new ArrayList<>();
	
	DrawableUnit obj;

	public void loop(long window) {
		int tirell = 2;
		while(!glfwWindowShouldClose(window)) {
			glfwSwapBuffers(window);
			screen.clean();
			for(DrawableObject obj : objs) {
				screen.draw(obj);
			}
			glfwPollEvents();
			try {
//				obj.setX(obj.getX() + 15);
				if(!(probe1.getX() <= 800 && probe1.getX() >= 0)){
					tirell = -tirell;
				}
				probe1.setX(probe1.getX() + tirell);
//				Thread.sleep(1);
			} catch (Exception e) {
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
