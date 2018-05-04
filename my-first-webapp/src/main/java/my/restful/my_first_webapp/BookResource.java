package my.restful.my_first_webapp;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import my.restful.my_first_webapp.entity.Book;

@Path("book")
public interface BookResource {
	@GET
	public String getWeight();

	@PUT
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_XML)
	public String newBook(Book book);

	@DELETE
	public void delete(@QueryParam("bookId") final Long bookId);

	@POST
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Book createBook(Book book);
}
