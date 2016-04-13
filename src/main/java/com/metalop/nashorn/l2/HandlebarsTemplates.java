package com.metalop.nashorn.l2;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class HandlebarsTemplates {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		
		try(InputStream is = HandlebarsTemplates.class.getResourceAsStream("HandlebarsTemplates.js")){
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			engine.eval(reader);
			Invocable invocable = (Invocable) engine;
			
			ArrayList<Map<String,String>> items = new ArrayList<>();
			HashMap<String, String> item = new HashMap<>();
			item.put("name", "Nokia 1100");
			item.put("quantity", "10");
			items.add(item);
			
			item = new HashMap<>();
			item.put("name", "iPhone 7");
			item.put("quantity", "2");
			items.add(item);
			
			OrderDetails order = new OrderDetails();
			order.user ="Tim";
			order.orderId= 12314;
			order.items =  items;
			
			GsonBuilder builder = new GsonBuilder();
			Gson gson = builder.create();
			
			// calling the JavaScript function to generate the template
			invocable.invokeFunction("generateTemplate",gson.toJson(order));
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
class OrderDetails{
	String user;
	Integer orderId;
	ArrayList<Map<String,String>> items = new ArrayList<>();
	
	
}
