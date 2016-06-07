package com.metalop.nashorn.hello_world_react_servlet;

import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metalop.nashorn.utilities.Utilities;

public class HelloWorldServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	 @Override
     protected void doGet( HttpServletRequest request,HttpServletResponse response ) throws ServletException,IOException
     {
         response.setContentType("text/html");
         response.setStatus(HttpServletResponse.SC_OK);
         ScriptEngine nashorn =  new ScriptEngineManager().getEngineByName("nashorn");
         try {
			nashorn.eval(Utilities.ReadFromResources("React(with addons)v15.1.0.js"));
			nashorn.eval(Utilities.ReadFromResources("ReactDOMServerV5.1.0.js"));
			nashorn.eval(Utilities.ReadFromResources("HelloWorldReactApp.js"));
			Invocable invocable = (Invocable) nashorn;
			String s = (String) invocable.invokeFunction("getHelloWorldMarkup");
			response.getWriter().println(s);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
        
     }

}
