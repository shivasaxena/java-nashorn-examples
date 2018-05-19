package com.metalop.nashorn.tutorials.spring.boot.basic;

import java.util.Arrays;

import javax.script.ScriptException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication

public class FirstSpringBootNashornApplication {

	@Autowired
	ScriptClass scriptClass;

	public static void main(String[] args) throws ScriptException {

		SpringApplication.run(FirstSpringBootNashornApplication.class, args);

	}

	@Component
	public class CommandLineAppStartupRunner implements CommandLineRunner {

		@Override
		public void run(String... args) throws Exception {
			scriptClass.executeHelloWorldJavaScript();
		}
	}

}
