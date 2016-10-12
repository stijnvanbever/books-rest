package be.stijn.books.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import be.stijn.books.model.Book;

@Path("books")
public class BookService {
	
	private EntityManager em;
	
	public BookService() {
		EntityManagerFactory emManagerFactory = Persistence.createEntityManagerFactory("books");
		em = emManagerFactory.createEntityManager();
	}
	
	@GET
	@Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String getBook(@PathParam(value = "name") String bookName) {
		return String.format("Book with name: [%s]", bookName);
	}
	
	@GET
	@Path("allBooks")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		List<Book> books = em.createQuery("from Book", Book.class).getResultList();
		
		return books;
	}
}
