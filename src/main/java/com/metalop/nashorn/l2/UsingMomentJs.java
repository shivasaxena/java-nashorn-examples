package com.metalop.nashorn.l2;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class UsingMomentJs {

	public static void main(String[] args) {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		try(InputStream is = UsingMomentJs.class.getResourceAsStream("HelloWorld.js")){
		
			BufferedReader br = new BufferedReader(new InputStreamReader(UsingMomentJs.class.getResourceAsStream("moment-with-locales.js")));
			engine.eval(br);
			
			// date formatting
			String convertedDate = engine.eval( "new moment(" +System.currentTimeMillis() + ").format('MMMM Do, YYYY');" ).toString();
			System.out.println(convertedDate);
			
			convertedDate = engine.eval( "new moment(" +System.currentTimeMillis() + ").format('dddd, MMMM Do YYYY, h:mm:ss a');" ).toString();
			System.out.println(convertedDate);
			
			
			// date addition
			convertedDate = engine.eval( "new moment().add(1, 'days').calendar();" ).toString();
			System.out.println(convertedDate);
			
			// date internationalization (converting date to Hindi in this case)formatting
			convertedDate = engine.eval( "new moment(" +System.currentTimeMillis() + ").locale('hi').format('MMMM Do, YYYY');" ).toString();
			System.out.println(convertedDate);
			
		}catch(Exception e){
			e.printStackTrace();
		}
}

}
