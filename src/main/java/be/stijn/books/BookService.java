package be.stijn.books;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("books")
public class BookService {

	@GET
	@Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBook(@PathParam(value = "name") String bookName) {
		return String.format("Book with name: [%s]", bookName);
	}
}
