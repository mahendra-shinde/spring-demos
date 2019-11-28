package com.mahendra.booklib.dao;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.mahendra.booklib.models.BookIssue;
import com.mahendra.booklib.models.Member;

/**
 * @author mahendra shinde (MahendraShinde@synergetics-india.com
 *
 */
@Repository
public class MemberDAOImpl implements MemberDAO {

	@PersistenceContext
	private EntityManager em;

	private static Logger log = Logger.getLogger("MemberDAOImpl");

	@Override
	public Member findById(Integer id) {
		log.info("Finding member " + id);
		return em.find(Member.class, id);

	}

	@Override
	public List<Member> findByFirstName(String firstName) {
		log.info("Find member by First Name " + firstName);
		return createQuery("from Member m where lower(m.firstName)= lower(?1)", firstName).getResultList();
	}

	@Override
	public List<Member> findByLastName(String lastName) {
		log.info("Find member by Last Name "+lastName);
		return createQuery("from Member m where lower(m.lastName)= lower(?1)", lastName).getResultList();
		}

	@Override
	public void update(Member member) {
		log.info("Updating member record "+member.getId());
		em.merge(member);
	}

	@Override
	public Integer save(Member member) {
		log.info("Creating new member "+member.getFirstName());
		em.persist(member);
		return member.getId();
	}

	
	//Helper method that ALWAYS creates TYPED-QUERY for Member entity
	private TypedQuery<Member> createQuery(String query,Object ... params) {
		TypedQuery<Member> q= em.createQuery(query,Member.class);
		for(int i=0;i<params.length;i++) {
			q.setParameter(i+1, params[i]);
		}
		return q;
	
	}

}
