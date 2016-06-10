package com.metalop.nashorn.hello_world_react_servlet;

import java.io.FileReader;
import java.io.IOException;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metalop.nashorn.utilities.Utilities;

public class HelloWorldWithReact_Jsx extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ScriptEngine nashorn =  new ScriptEngineManager().getEngineByName("nashorn");
	private SimpleBindings bindings = new SimpleBindings();

	@Override
	public void init() throws ServletException {
		try{
		nashorn.eval(Utilities.readFromResourcesAsInputStream("React(with addons)v15.1.0.js"));
		nashorn.eval(Utilities.readFromResourcesAsInputStream("ReactDOMServerV5.1.0.js"));
		nashorn.eval(Utilities.readFromResourcesAsInputStream("babel-core-6.7.7-browser.js"),bindings);
		String unTranspiledJsx = Utilities.readFromResourcesAsString("HelloWorldReactApp.jsx");
		bindings.put("input", unTranspiledJsx);
		String transpileJavaScript = (String) nashorn.eval("Babel.transform(input, { presets: ['react'] }).code", bindings);
		nashorn.eval(transpileJavaScript);
		super.init();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);	
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
         response.setStatus(HttpServletResponse.SC_OK);
         
         try {
			String outputHtml = (String) nashorn.eval("ReactDOMServer.renderToString(React.createElement(ReactPageComponent));");
			response.getWriter().println(outputHtml);	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		   
        try {
        	//read the submitted name value 
        	// will work if the content type head is set as "Content-Type: application/x-www-form-urlencoded"
        	// payload should be in the format "name=Shiva" without quotes
        	String name = req.getParameter("name");
			String outputHtml = (String) nashorn.eval("ReactDOMServer.renderToString(React.createElement(ReactPageComponent,{name:'"+name+"'}));");
			response.getWriter().println(outputHtml);	
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	

}
