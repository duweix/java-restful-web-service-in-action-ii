package my.restful.my_first_webapp.test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import my.restful.my_first_webapp.EBookResourceImpl;
import my.restful.my_first_webapp.entity.Book;

public class PUTTest extends JerseyTest {
	private static final Logger LOGGER = Logger.getLogger(JerseyTest.class.getName());
	private static AtomicLong clientBookSequence = new AtomicLong();

	@Override
	protected Application configure() {
		return new ResourceConfig(EBookResourceImpl.class);
	}

	@Test
	public void testNew() {
		final Book newBook = new Book(clientBookSequence.incrementAndGet(), "book-" + System.nanoTime());
		MediaType contentTypeMediaType = MediaType.APPLICATION_XML_TYPE;
		MediaType acceptMediaType = MediaType.TEXT_PLAIN_TYPE;
		final Entity<Book> bookEntity = Entity.entity(newBook, contentTypeMediaType);
		final String lastUpdate = target("book").request(acceptMediaType).put(bookEntity, String.class);
		Assert.assertNotNull(lastUpdate);
		LOGGER.info("lastUpdate: " + lastUpdate);
	}
}
