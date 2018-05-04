package my.restful.my_first_webapp.app;

import org.glassfish.jersey.servlet.ServletContainer;

//@WebServlet(initParams = @WebInitParam(name = "jersey.config.server.provider.packages", value = "my.restful.my_first_webapp"), urlPatterns = "/webapi/*", loadOnStartup = 1)
public class AirServlet extends ServletContainer {
	private static final long serialVersionUID = 1L;
}
