package ru.coutvv.oop.samples.graph.architecture;

import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;

import java.util.ArrayList;
import java.util.List;

import ru.coutvv.oop.samples.graph.architecture.model.DrawableUnit;
import ru.coutvv.oop.samples.graph.architecture.time.Scene;
import ru.coutvv.oop.samples.graph.architecture.time.SimpleScene;
import ru.coutvv.oop.samples.starcraft.unit.protoss.Probe;

/**
 * Синглтон игры
 * 
 * @author lomovtsevrs
 */
public class Game {

	private static Game instance = new Game();
	
	private Screen screen;
	private Scene scene;
	private Game() {
		screen = new Screen();
		long window = screen.init();
		//вынести в фабрику?
		int probeTexture = screen.loadTexture("src/main/resources/probe.png");
		scene = new SimpleScene(probeTexture);
		loop(window);
		
	}
	
	
	DrawableUnit obj;

	public void loop(long window) {
		while(!glfwWindowShouldClose(window)) {
			glfwSwapBuffers(window);
			screen.clean();
			for(DrawableObject obj : scene.getObjects()) {
				screen.draw(obj);
			}
			glfwPollEvents();
			scene.turnAround();
		}
	}
	
	public static Game getInstance() { 
		return instance;
	}
	
	public static void main(String[] args) {
		Game.getInstance();
	}
}
