package my.restful.my_first_webapp.test;

import java.util.logging.Logger;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import my.restful.my_first_webapp.resource.QueryResourceImpl;

public class QueryResourceImplTest extends JerseyTest {
	private static final Logger LOGGER = Logger.getLogger(QueryResourceImplTest.class.getName());

	@Override
	protected Application configure() {
		return new ResourceConfig(QueryResourceImpl.class);
	}

	@Test
	public void testCase_getByPaging() {
		String yijings = target("query-resource/yijings").queryParam("start", 1).queryParam("size", 5)
				.request(MediaType.TEXT_PLAIN_TYPE).get(String.class);
		LOGGER.info(yijings);
	}
}
