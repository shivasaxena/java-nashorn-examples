package com.metalop.nashorn.javafx;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

import javafx.application.Application;
import javafx.stage.Stage;

public class GettingStarted extends Application {

	public static void main(String args[]) {

		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

		try (InputStream is = GettingStarted.class.getResourceAsStream("getting-started.js")) {

			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			SimpleBindings bindings = new SimpleBindings();
			bindings.put("$STAGE", primaryStage);
			engine.eval(reader, bindings);
			

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
