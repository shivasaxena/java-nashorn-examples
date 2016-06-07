package com.metalop.nashorn.utilities;

import java.io.InputStream;
import java.io.InputStreamReader;

public class Utilities {

	public static InputStreamReader ReadFromResources(String path) {
		InputStream in = Utilities.class.getClassLoader().getResourceAsStream(path);
		return new InputStreamReader(in);
	}
}
