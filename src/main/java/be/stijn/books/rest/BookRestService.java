package be.stijn.books.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import be.stijn.books.model.Book;
import be.stijn.books.service.TestEJB;

@Path("books")
@Stateful
public class BookRestService {
	
	@PersistenceContext(unitName = "books")
	private EntityManager em;
	
	@EJB
	private TestEJB testEJB;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAllBooks() {
		List<Book> books = em.createQuery("from Book", Book.class).getResultList();
		
		return books;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBook(Book book) {
		em.persist(book);
	}
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("test")
	public String test() {
		return testEJB.getTest();
	}
}
