package ru.coutvv.oop.samples.graph;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;

public class MySample {

	private long window;
	
	public void run() {
		System.out.println("Hello stupid bitch! " + Version.getVersion() + " !");
		try {
			init();
			loop();
			
			//освободить окошечные возвраты и уничтожить окно
			glfwFreeCallbacks(window);
			glfwDestroyWindow(window);
		} finally {
			//ломаем GLFW и освобождаем стэк ошибок
			glfwTerminate();
			glfwSetErrorCallback(null).free();
		}
	}
	
	
	private void init() {
		GLFWErrorCallback.createPrint(System.err).set();
		
		if(!glfwInit()) 
			throw new IllegalStateException("Невозможно инициализировать GLFW");
		
		glfwDefaultWindowHints(); //все подсказки выставлены по умолчанию
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); //окошко спрятано после создания
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
		
		int WIDTH = 300;
		int HEIGHT = 300;
		
		window = glfwCreateWindow(WIDTH, HEIGHT, "My first glfw app!@", NULL, NULL);
		if(window == NULL) 
			throw new RuntimeException("Тупаноло при создании GLFW окошка");
		
		// устанавливаем колбэк на клавишу
		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) 
				glfwSetWindowShouldClose(window, true);
		});
		
		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
		
		glfwSetWindowPos(
				window, 
				(vidmode.width() - WIDTH)/2, 
				(vidmode.height() - HEIGHT)/2);
		glfwMakeContextCurrent(window);
		glfwSwapInterval(1);
		
		glfwShowWindow(window);
	}
	

	private void loop() {
		GL.createCapabilities();
		
		glClearColor(42.0f, 0.0f, 0.0f, 0.0f);
		
		while(!glfwWindowShouldClose(window)) {
			glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
			glfwSwapBuffers(window);
			
			glfwPollEvents();
		}
	}
	
	public static void main(String[] args) {
		new MySample().run();
	}
}
