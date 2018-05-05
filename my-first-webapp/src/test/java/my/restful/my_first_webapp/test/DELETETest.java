package my.restful.my_first_webapp.test;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import my.restful.my_first_webapp.resource.EBookResourceImpl;

public class DELETETest extends JerseyTest {

	@Override
	protected Application configure() {
		return new ResourceConfig(EBookResourceImpl.class);
	}

	@Test
	public void testDelete() {
		final Response response = target("book").queryParam("bookId", "9527").request().delete();
		int status = response.getStatus();
		Assert.assertEquals(Response.Status.NO_CONTENT.getStatusCode(), status);
	}
}
