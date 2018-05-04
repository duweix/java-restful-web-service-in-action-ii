package my.restful.my_first_webapp;

import java.util.logging.Logger;

import my.restful.my_first_webapp.entity.Book;

public class EBookResourceImpl implements BookResource {
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

}