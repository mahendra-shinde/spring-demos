package com.mahendra.booklib.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.mahendra.booklib.models.Book;
import com.mahendra.booklib.models.Member;

@Repository
public class BookDAOImpl implements BookDAO {

	private static Logger log = Logger.getLogger("BookDAOImpl");

	@PersistenceContext(type=PersistenceContextType.TRANSACTION)
	private EntityManager em;

	@Override
	public Book findById(Integer id) {
		// TODO Auto-generated method stub
		log.info("Finding book with id " + id);
		Book book = em.find(Book.class, id);
		return book;
	}

	@Override
	public List<Book> findByAuthor(String author) {
		log.info("Finding books written by author " + author);
		List<Book> temp = createQuery("from Book b where lower(b.author) = lower(?1)", author)
				.getResultList();
		log.info("Found " + temp.size() + " books");
		return temp;
	}

	@Override
	public List<Book> findByCategory(String category) {
		log.info("Finding books by category " + category);
		List<Book> temp = createQuery("from Book b where lower(b.category) = lower(?1)", category).getResultList();
		log.info("Found " + temp.size() + "books");
		return temp;
	}

	@Override
	public List<Book> findByTitle(String title) {
		log.info("Finding books by title " + title);
		List<Book> temp = createQuery("from Book b where lower(b.title) like concat('%',lower(?1),'%')", title)
				.getResultList();
		log.info("Found " + temp.size() + "books");
		return temp;
	}

	@Override
	public List<Book> findAvailableByTitle(String title) {
		log.info("Finding available books by title " + title);
		List<Book> temp = createQuery("from Book b where b.status = 'A' and lower(b.title) = lower(?1)"
				, title).getResultList();
		log.info("Found " + temp.size() + "books");
		return temp;
	}

	@Override
	public List<Book> findAvailableByAuthor(String author) {
		log.info("Finding available books written by author " + author);
		List<Book> temp = createQuery("from Book b where b.status = 'A' and lower(b.author) = lower(?1)"
				, author).getResultList();
		log.info("Found " + temp.size() + " books");
		return temp;
	}

	@Override
	public List<Book> findAvailableByCategory(String category) {
		log.info("Finding books by category " + category);
		List<Book> temp = createQuery("from Book b where b.status = 'A' and lower(b.category) = lower(?1)"
				, category).getResultList();
		log.info("Found " + temp.size() + "books");
		return temp;
	}

	@Override
	public void update(Book book) {
		log.info("Updating book " + book.getId());
		em.merge(book);
	}

	@Override
	public Integer save(Book book) {
		log.info("Creating new book");
		em.persist(book);
		return book.getId();
	}

	private TypedQuery<Book> createQuery(String query, Object ... params) {
		TypedQuery<Book> q= em.createQuery(query,Book.class);
		for(int i=0;i<params.length;i++) {
			q.setParameter(i+1, params[i]);
		}
		return q;
		}

	@Override
	public void delete(Book book) {
		em.remove(book);
	}
}
