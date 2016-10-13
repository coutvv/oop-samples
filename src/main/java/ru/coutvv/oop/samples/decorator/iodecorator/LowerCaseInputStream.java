package ru.coutvv.oop.samples.decorator.iodecorator;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {

	public LowerCaseInputStream(InputStream in) {
		super(in);
	}

	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase(c));
	}
	
	public int read(byte[] b, int offset, int len) throws IOException {
		int result = super.read(b, offset, len);
		for(int i = offset; i < offset + result; i++) {
			b[i] = (byte)Character.toLowerCase((char)b[i]);
		}
		return result;
	}
	
	// эт для удобства, но изза контракта InputStream типа не надо
	public String readAll() throws IOException {
		int c;
		StringBuffer result = new StringBuffer("");
		while((c = in.read()) >= 0 ) {
			System.out.print((char) c);
			result.append((char)c);
		}
		return result.toString();
	}
}
