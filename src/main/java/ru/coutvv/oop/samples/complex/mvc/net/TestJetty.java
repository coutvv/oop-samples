package ru.coutvv.oop.samples.complex.mvc.net;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.Configuration.ClassList;
import org.eclipse.jetty.webapp.WebAppContext;

public class TestJetty {

	public static void main(String[] args) throws Exception {
		Server server  =new Server(8080);
		// 2. Creating the WebAppContext for the created content
		WebAppContext ctx = new WebAppContext();
		ctx.setResourceBase("src/main/webapp");
		ctx.setContextPath("/jetty-jsp-example");
		
		//3. Including the JSTL jars for the webapp.
		ctx.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",".*/[^/]*jstl.*\\.jar$");
		
		ctx.addServlet(new ServletHolder(new NetDJView()), "/jsp/djview/servlet/DJView");
		
		//4. Enabling the Annotation based configuration
		ClassList classList = ClassList.setServerDefault(server);

		classList.addAfter("org.eclipse.jetty.webapp.FragmentConfiguration", "org.eclipse.jetty.plus.webapp.EnvConfiguration", "org.eclipse.jetty.plus.webapp.PlusConfiguration");
		classList.addBefore("org.eclipse.jetty.webapp.JettyWebXmlConfiguration", "org.eclipse.jetty.annotations.AnnotationConfiguration");
//		server.addConnector();
		server.setHandler(ctx);
		server.start();
		server.join();
	}
}
