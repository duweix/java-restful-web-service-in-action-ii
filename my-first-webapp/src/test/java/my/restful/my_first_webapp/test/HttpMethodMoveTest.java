package my.restful.my_first_webapp.test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.grizzly.connector.GrizzlyConnectorProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import my.restful.my_first_webapp.resource.EBookResourceImpl;

public class HttpMethodMoveTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(EBookResourceImpl.class);
	}

	@Override
	protected void configureClient(ClientConfig config) {
		config.connectorProvider(new GrizzlyConnectorProvider());
		super.configureClient(config);
	}

	@Test
	public void testWebDav() {
		final Response response = target("book").request().method("MOVE");
		Boolean result = response.readEntity(Boolean.class);
		Assert.assertEquals(Boolean.TRUE, result);
	}
}
