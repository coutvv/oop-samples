package ru.coutvv.oop.samples.graph.architecture;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_RESIZABLE;
import static org.lwjgl.glfw.GLFW.GLFW_TRUE;
import static org.lwjgl.glfw.GLFW.GLFW_VISIBLE;
import static org.lwjgl.glfw.GLFW.glfwCreateWindow;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;
import static org.lwjgl.glfw.GLFW.glfwGetPrimaryMonitor;
import static org.lwjgl.glfw.GLFW.glfwGetVideoMode;
import static org.lwjgl.glfw.GLFW.glfwInit;
import static org.lwjgl.glfw.GLFW.glfwMakeContextCurrent;
import static org.lwjgl.glfw.GLFW.glfwPollEvents;
import static org.lwjgl.glfw.GLFW.glfwSetWindowPos;
import static org.lwjgl.glfw.GLFW.glfwShowWindow;
import static org.lwjgl.glfw.GLFW.glfwSwapBuffers;
import static org.lwjgl.glfw.GLFW.glfwSwapInterval;
import static org.lwjgl.glfw.GLFW.glfwWindowHint;
import static org.lwjgl.glfw.GLFW.glfwWindowShouldClose;
import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.system.MemoryUtil.NULL;

import java.awt.image.BufferedImage;
import java.io.File;

import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.GLFWVidMode;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;

import ru.coutvv.oop.samples.graph.TextureLoader;

public class Screen {

	private long window;
	
	private final int WIDTH;
	private final int HEIGHT;
	
	public Screen() {
		WIDTH = 800;
		HEIGHT = 600;
	}
	
	public Screen(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
	}

	public long init() {
		GLFWErrorCallback.createPrint(System.err).set();

		if (!glfwInit())
			throw new IllegalStateException("Невозможно инициализировать GLFW");

		glfwDefaultWindowHints(); // все подсказки выставлены по умолчанию
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // окошко спрятано после создания
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);


		window = glfwCreateWindow(WIDTH, HEIGHT, "That screen...", NULL, NULL);
		
		if (window == NULL) throw new RuntimeException("Тупаноло при создании GLFW окошка");

		GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

		glfwSetWindowPos(window, (vidmode.width() - WIDTH) / 2, (vidmode.height() - HEIGHT) / 2);
		glfwMakeContextCurrent(window);
		glfwSwapInterval(1);

		glfwShowWindow(window);
		
		
		//loop setups
		GL.createCapabilities();
		GL11.glLoadIdentity();
		GL11.glOrtho(0, 800, 0, 600, 1, -1);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		
		glEnable(GL_BLEND);
		glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
		return window;
	}

	public void draw(DrawableObject obj) {
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, obj.getTextureId());
		int x = (int) obj.getX(), y = (int) obj.getY(), width = obj.getWidth(), height = obj.getHeight();
		GL11.glBegin(GL11.GL_QUADS);
			GL11.glTexCoord2f(0, 1);
			GL11.glVertex2f(x, y);
			GL11.glTexCoord2f(1, 1);
			GL11.glVertex2f(x + width, y);
			GL11.glTexCoord2f(1, 0);
			GL11.glVertex2f(x + width, y + height);
			GL11.glTexCoord2f(0, 0);
			GL11.glVertex2f(x, y + height);
		GL11.glEnd();
	}
	
	public void clean() {
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
	}

	public int loadTexture(String filename) {
		File file = new File(filename);
		BufferedImage im = TextureLoader.loadImage(file);
		return TextureLoader.loadTexture(im);
	}
	
}
