package com.metalop.nashorn.hello_world_es6_syntax;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;
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
        	SimpleBindings bindings = new SimpleBindings();
        	nashorn.eval(Utilities.readFromResourcesAsInputStream("babel-core-6.7.7-browser.js"),bindings);
         	String unTranspiledJsx = Utilities.readFromResourcesAsString("HelloWorldEs6Syntax.js");
    		bindings.put("input", unTranspiledJsx);
    		String transpileJavaScript = (String) nashorn.eval("Babel.transform(input, { presets: ['es2015'] }).code", bindings);
    		String s = (String)nashorn.eval(transpileJavaScript);
			response.getWriter().println(s);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
        
     }

}
