package ru.coutvv.oop.samples.graph;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.ByteBuffer;

import javax.imageio.ImageIO;

import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class TextureLoader {

	public static BufferedImage loadImage(File image) {
		BufferedImage result = null;
		try {
			result = ImageIO.read(image);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	private static int BYTE_PER_PIXEL = 4; //for RGBA, 3 for RGB
	
	public static int loadTexture(BufferedImage image) {
		int[] pixels = new int[image.getWidth()*image.getHeight()];
		image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());
		
		ByteBuffer buf = BufferUtils.createByteBuffer(image.getWidth()*image.getHeight()*BYTE_PER_PIXEL);
		
		for(int y = 0; y < image.getHeight(); y++)  {
			for(int x = 0; x < image.getWidth(); x++) {
				int pixel = pixels[y*image.getWidth() + x]; 
				buf.put((byte)((pixel >>16) & 0xFF)); //r
				buf.put((byte)((pixel >>8) & 0xFF));// g
				buf.put((byte)(pixel & 0xFF)); //b
				buf.put((byte)((pixel >>24) & 0xFF)); //alpha component, only for rgba
			}
		}
		buf.flip();
		
		
		int textureId = GL11.glGenTextures();
		GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureId);
		
		//setup wrap mode
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL12.GL_CLAMP_TO_EDGE);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL12.GL_CLAMP_TO_EDGE);
		
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_NEAREST);
		GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_NEAREST);
		
		GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA8, image.getWidth(), image.getHeight(), 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, buf);
		return textureId;
	}
	
}
