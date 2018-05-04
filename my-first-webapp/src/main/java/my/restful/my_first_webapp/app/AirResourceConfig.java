package my.restful.my_first_webapp.app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;

@ApplicationPath("/webapi/*")
public class AirResourceConfig extends ResourceConfig {
	public AirResourceConfig() {
		property(ServerProperties.WADL_FEATURE_DISABLE, false);
		packages("my.restful.my_first_webapp");
	}
}
