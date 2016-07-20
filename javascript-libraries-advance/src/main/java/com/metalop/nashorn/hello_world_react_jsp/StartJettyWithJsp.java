package com.metalop.nashorn.hello_world_react_jsp;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;

public class StartJettyWithJsp {

	public static void main(String[] args) throws Exception {
		// 1. Creating the server on port 8080
				Server server = new Server(8080);

				// 2. Creating the WebAppContext for the created content
				WebAppContext ctx = new WebAppContext();
				ctx.setResourceBase("src/main/java/com/metalop/nashorn/hello_world_react_jsp/jsp_pages/");
				ctx.setContextPath("/react-jsp-example");
				
				//3. Including the JSTL jars for the webapp.
				ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/[^/]*jstl.*\\.jar$");
			
				//4. Enabling the Annotation based configuration
				org.eclipse.jetty.webapp.Configuration.ClassList classlist = org.eclipse.jetty.webapp.Configuration.ClassList.setServerDefault(server);
		        classlist.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration", "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
		        classlist.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");
		        
		        //5. Setting the handler and starting the Server
				server.setHandler(ctx);
				server.start();
				server.join();
	}

}
