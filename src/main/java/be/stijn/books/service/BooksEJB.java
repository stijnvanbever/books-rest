package be.stijn.books.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import be.stijn.books.model.Book;

@Stateless
public class BooksEJB {
	
	@PersistenceContext(unitName = "books")
	private EntityManager em;
	
	public List<Book> getAllBooks() {
		List<Book> books = em.createQuery("from Book", Book.class).getResultList();
		
		return books;
	}
	
	public void addBook(Book book) {
		em.persist(book);
	}

	public void removeBook(Long id) {
		Book book = em.find(Book.class, id);
		em.remove(book);
	}
}
