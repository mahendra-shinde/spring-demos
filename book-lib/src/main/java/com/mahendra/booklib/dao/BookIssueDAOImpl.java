package com.mahendra.booklib.dao;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mahendra.booklib.models.BookIssue;

@Repository
public class BookIssueDAOImpl implements BookIssueDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public BookIssue findById(Integer id) {
		BookIssue issue = em.find(BookIssue.class, id);
		return issue;
	}

	@Override
	public List<BookIssue> findByIssueDate(Date issueDate) {
		List<BookIssue> issues = createQuery("from BookIssue i where i.dateOfIssue = ?1 ", issueDate).getResultList();
		return issues;
	}

	@Override
	public List<BookIssue> findByEstimatedReturnDate(Date estimatedReturnDate) {
		List<BookIssue> issues = createQuery("from BookIssue i where i.estimatedReturnDate = ?1", estimatedReturnDate).getResultList();
		return issues;
	}

	@Override
	public List<BookIssue> findByBookId(Integer bookId) {
		List<BookIssue> issues = createQuery("from BookIssue i where i.book.id = ?1", bookId).getResultList(); 
		return issues;
	}

	@Override
	public List<BookIssue> findByMemberId(Integer memberId) {
		List<BookIssue> issues = createQuery("from BookIssue i where i.member.id = ?1",memberId).getResultList(); 
		return issues;
	}

	@Override
	public void update(BookIssue bookIssue) {
		em.merge(bookIssue);
	}

	@Override
	public void save(BookIssue bookIssue) {
		em.persist(bookIssue);

	}
	
	
	/**
	 * Utility method to quickly create a Typed
	 * @param query
	 * @param params
	 * @return
	 */
	private TypedQuery<BookIssue> createQuery(String query,Object ... params){
		TypedQuery<BookIssue> q= em.createQuery(query,BookIssue.class);
		for(int i=0;i<params.length;i++) {
			q.setParameter(i+1, params[i]);
		}
		return q;
	}

}
