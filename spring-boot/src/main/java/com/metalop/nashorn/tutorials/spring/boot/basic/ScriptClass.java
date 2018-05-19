package com.metalop.nashorn.tutorials.spring.boot.basic;

import javax.script.ScriptEngine;
import javax.script.ScriptException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ScriptClass {
	@Autowired
	ScriptEngine scriptEngine;

	protected void executeHelloWorldJavaScript() throws ScriptException {
		scriptEngine.eval("print(' \\n Hello Spring Boot from JavaScript \\n')");
	}
}
