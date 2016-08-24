package com.metalop.nashorn.hello_world_es6_syntax;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class StartApp {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ServletHandler servletHandeler = new ServletHandler();
		servletHandeler.addServletWithMapping(HelloWorldServlet.class, "/hello-from-es6-syntax");
		server.setHandler(servletHandeler);
		server.start();
		server.join();

	}

}
