import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class HelloWorldFromJsFile {

	public static void main(String[] args) throws ScriptException, IOException, NoSuchMethodException {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		
		try(InputStream is = HelloWorldFromJsFile.class.getResourceAsStream("HelloWorld.js")){
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			engine.eval(reader);
			Invocable invocable = (Invocable) engine;
			// Calling a JavaScript function without arguments
			invocable.invokeFunction("printHelloWorld");
			
			//taking name as input
			System.out.println("Please enter your name.");
			Scanner s = new Scanner(new InputStreamReader(System.in));
			String name = s.nextLine();
			s.close();
			//calling a JavaScript function with arguments
			invocable.invokeFunction("helloUser", name);
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
