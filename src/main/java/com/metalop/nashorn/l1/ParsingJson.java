package com.metalop.nashorn.l1;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ParsingJson {

	public class Person {

		String firstName;
		String lastName;
		Integer age;

		public Person(String firstName, String lastName, Integer age) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;

		}
	}

	public static void main(String args[]) throws ScriptException {

		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		engine.eval("print('Hello World!');");
		ParsingJson p = new ParsingJson();
		Person p1 = p.new Person("Bruce", "Wayne", 45);
		
		String jsonValue = (String) engine.eval("JSON.stringify("+p1.toString()+");");
		
	}
}
