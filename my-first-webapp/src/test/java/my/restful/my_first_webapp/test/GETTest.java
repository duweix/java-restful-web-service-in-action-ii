package my.restful.my_first_webapp.test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import my.restful.my_first_webapp.EBookResourceImpl;

public class GETTest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(EBookResourceImpl.class);
	}

	@Test
	public void testGet() {
		Response response = target("book").request().get();
		Assert.assertEquals("150M", response.readEntity(String.class));
	}
}
