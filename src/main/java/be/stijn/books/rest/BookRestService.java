package be.stijn.books.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import be.stijn.books.model.Book;
import be.stijn.books.service.BooksEJB;

@Path("books")
@Stateful
public class BookRestService {
	
	@EJB
	private BooksEJB booksService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		return booksService.getAllBooks();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBook(Book book) {
		booksService.addBook(book);
	}
	
	@DELETE
	@Path("/{id}")
	public void removeBook(@PathParam(value = "id") Long id) {
		booksService.removeBook(id);
	}
}
