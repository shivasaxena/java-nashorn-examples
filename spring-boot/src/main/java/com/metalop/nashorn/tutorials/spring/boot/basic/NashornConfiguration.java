package com.metalop.nashorn.tutorials.spring.boot.basic;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NashornConfiguration {

	@Bean
	public ScriptEngine scriptEngine() {
		return new ScriptEngineManager().getEngineByName("nashorn");
	}

}
