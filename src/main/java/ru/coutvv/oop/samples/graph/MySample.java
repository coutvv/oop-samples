package ru.coutvv.oop.samples.graph;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.*;

import java.awt.image.BufferedImage;
import java.io.File;

import org.lwjgl.Version;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

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
		
		int WIDTH = 800;
		int HEIGHT = 600;
		
		window = glfwCreateWindow(WIDTH, HEIGHT, "My first glfw app!@", NULL, NULL);
		if(window == NULL) 
			throw new RuntimeException("Тупаноло при создании GLFW окошка");
		
		// устанавливаем колбэк на клавишу
		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			if (key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE) 
				glfwSetWindowShouldClose(window, true);
		});
		
		glfwSetKeyCallback(window, (window, key, scancode, action, mods) -> {
			System.out.print("switch X:" + coordX);
			System.out.println("\tswitch Y:" + coordY);
			switch (key) {
			case GLFW_KEY_UP:
				if(coordY < 440)
				coordY += 10;
				break;
			case GLFW_KEY_DOWN:
				if(coordY > 0)
				coordY -= 10;
				break;
			case GLFW_KEY_LEFT: 
				if(coordX > 0)
				coordX -=10;
				break;
			case GLFW_KEY_RIGHT:
				if(coordX < 640)
				coordX += 10;
				break;
			case GLFW_KEY_ENTER:
				System.out.println(res);
				break;
			default:
				break;
			}
			System.out.print("switch X:" + coordX);
			System.out.println("\tswitch Y:" + coordY);
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
//		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		//experimenst TODO:
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		texture();
		while(!glfwWindowShouldClose(window)) {
			glfwSwapBuffers(window);
			glEnable(GL_BLEND);
			glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			step();
			glDisable(GL_BLEND);
			glfwPollEvents();
		}
	}
	
	public void step() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
		GL11.glColor4f(1.0f, 1.0f,1.0f,1.0f);
//		
//		GL11.glBegin(GL11.GL_QUADS);
//		GL11.glVertex2f(100, 100);
//		GL11.glVertex2f(100+200,  100);
//		GL11.glVertex2f(100+200,  100+200);
//		GL11.glVertex2f(100,  100+200);
//		GL11.glEnd();
//		
//		
//		
//		
//		GL11.glColor3f(0.8f, .3f, 0.2f);
//		
//		GL11.glBegin(GL11.GL_QUADS);
//		GL11.glVertex2f(140, 140);
//		GL11.glVertex2f(140+160,  140);
//		GL11.glVertex2f(140+160,  140+160);
//		GL11.glVertex2f(140,  140+160);
//		GL11.glEnd();
//		
//		GL11.glColor3f(1.0f, 1.0f, 1.0f);
//		
//		GL11.glBegin(GL11.GL_TRIANGLES);
//		GL11.glVertex2f(coordX, coordY);
//		GL11.glVertex2f(coordX+160,  coordY);
//		GL11.glVertex2f(coordX+160,  coordY+160);
//		GL11.glEnd();
		//mariner
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(100, 100);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(100+200,  100);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(100+200,  100+200);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(100,  100+200);
		GL11.glEnd();
//		
	}
	
	private void texture() {
		File file = new File("src/main/resources/marine.png");
		img = TextureLoader.loadImage(file);
		res = TextureLoader.loadTexture(img);
	}
	
	private static int res;
	private int coordX = 300;
	private int coordY = 300;
	
	private static BufferedImage img;
	
	public static void main(String[] args) {

		new MySample().run();
	}
}
