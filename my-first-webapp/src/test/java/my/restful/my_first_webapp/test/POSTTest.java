package my.restful.my_first_webapp.test;

import java.util.logging.Logger;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Assert;
import org.junit.Test;

import my.restful.my_first_webapp.entity.Book;
import my.restful.my_first_webapp.resource.EBookResourceImpl;

public class POSTTest extends JerseyTest {
	private static final Logger LOGGER = Logger.getLogger(POSTTest.class.getName());

	@Override
	protected Application configure() {
		return new ResourceConfig(EBookResourceImpl.class);
	}

	@Test
	public void testPost() {
		final Book newBook = new Book("book-" + System.nanoTime());

		MediaType contentTypeMediaType = MediaType.APPLICATION_XML_TYPE;
		MediaType acceptMediaType = MediaType.APPLICATION_XML_TYPE;

		final Entity<Book> bookEntity = Entity.entity(newBook, contentTypeMediaType);
		final Book book = target("book").request(acceptMediaType).post(bookEntity, Book.class);

		Assert.assertNotNull(book.getBookId());
		LOGGER.info("" + book.getBookId());
	}
}
