package my.restful.my_first_webapp.resource;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import my.restful.my_first_webapp.entity.Book;
import my.restful.my_first_webapp.entity.Books;

public class EBookResourceImpl implements BookResource {
	private static final AtomicLong bookSequence = new AtomicLong();
	private static final Logger LOGGER = Logger.getLogger(EBookResourceImpl.class.getName());

	@Override
	public String getWeight() {
		return "150M";
	}

	@Override
	public String newBook(Book book) {
		return "" + System.nanoTime();
	}

	@Override
	public void delete(Long bookId) {
		LOGGER.info("" + bookId);
	}

	@Override
	public Book createBook(Book book) {
		book.setBookId(bookSequence.incrementAndGet());
		return book;
	}

	@Override
	public boolean moveBooks(Books books) {
		// TODO Auto-generated method stub
		return true;
	}

}
