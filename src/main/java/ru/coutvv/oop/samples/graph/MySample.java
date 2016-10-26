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
			if(action == GLFW_REPEAT) System.out.println("repeat");
			if(action == GLFW_RELEASE) return; //чтобы дважды не жалась
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
				System.out.println(marineTexture);
				break;
			default:
				break;
			}
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
		textureB();
		while(!glfwWindowShouldClose(window)) {
			glfwSwapBuffers(window);
			step();
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

//		//sky
//		GL11.glBindTexture(GL11.GL_TEXTURE_2D, skyTexture);
//		GL11.glBegin(GL11.GL_QUADS);
//			GL11.glTexCoord2f(1, 1);
//			GL11.glVertex2f(0, 0);
//			GL11.glTexCoord2f(0, 1);
//			GL11.glVertex2f(0+800,  0);
//			GL11.glTexCoord2f(0, 0);
//			GL11.glVertex2f(0+800,  0+600);
//			GL11.glTexCoord2f(1, 0);
//			GL11.glVertex2f(0,  0+600);
//		GL11.glEnd();
		
		//mariner
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, marineTexture);
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(coordX, coordY);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(coordX+200,  coordY);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(coordX+200,  coordY+200);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(coordX,  coordY+200);
		GL11.glEnd();
		
	}
	
	private void texture() {
		File file = new File("src/main/resources/marine.png");
		img = TextureLoader.loadImage(file);
		marineTexture = TextureLoader.loadTexture(img);
	}
	
	private void textureB() {
		File file = new File("src/main/resources/sky.png");
		BufferedImage im = TextureLoader.loadImage(file);
		skyTexture = TextureLoader.loadTexture(im);
	}
	
	private int skyTexture;
	private int marineTexture;
	private int coordX = 300;
	private int coordY = 300;
	
	private static BufferedImage img;
	
	public static void main(String[] args) {

		new MySample().run();
	}
}
