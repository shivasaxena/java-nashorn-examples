package com.metalop.nashorn.hello_world_react_servlet;



import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

public class StartApp {

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		ServletHandler servletHandeler = new ServletHandler();
		servletHandeler.addServletWithMapping(HelloWorldServlet.class, "/hello-from-react-js");
		servletHandeler.addServletWithMapping(HelloWorldWithReact_Jsx.class, "/hello-from-react-jsx");
		server.setHandler(servletHandeler);
		server.start();
		server.join();

	}

}
