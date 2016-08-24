package com.metalop.nashorn.utilities;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utilities {

	public static InputStreamReader readFromResourcesAsInputStream(String path) {
		InputStream in = Utilities.class.getClassLoader().getResourceAsStream(path);
		return new InputStreamReader(in);
	}
	public static String readFromResourcesAsString(String path) {
		String str = "";
		StringBuilder result = new StringBuilder("");
		try(InputStreamReader is = readFromResourcesAsInputStream(path);){
			
			BufferedReader reader = new BufferedReader(is);
			if (is != null) {                            
	            while ((str = reader.readLine()) != null) {    
	            	result.append(str + "\n" );
	            }                
	        }
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		return result.toString();

	  }
}
