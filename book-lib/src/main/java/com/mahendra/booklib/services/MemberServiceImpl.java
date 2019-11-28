/**
 * 
 */
package com.mahendra.booklib.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mahendra.booklib.dao.MemberDAO;
import com.mahendra.booklib.exceptions.ApplicationException;
import com.mahendra.booklib.models.Member;

/**
 * @author mahendra shinde (MahendraShinde@synergetics-india.com
 *
 */
@Service
public class MemberServiceImpl implements MemberService {
	
	private static Logger log = Logger.getLogger("MemberServiceImpl");
	@Autowired private MemberDAO dao;
	
	@Transactional
	@Override
	public void updateStatus(int memberId, String newStatus) {
		Member member = dao.findById(memberId);
		if(member==null) {
			new ApplicationException("Member "+memberId+" not found!");
		}
		log.info("Upading status for member "+memberId);
		member.setStatus(newStatus);
		dao.update(member);
		log.info("Status updated successfuly!");
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Override
	public int save(Member member) {
		int id =dao.save(member);
		return id;
	}

	

	@Override
	public Member findById(int memberId) {
		Member member = dao.findById(memberId);
		if(member == null) {
			throw new ApplicationException("Member not found");
		}
		return member;
	}

	@Override
	public List<Member> findByFirstName(String firstName) {
		List<Member> members = dao.findByFirstName(firstName);
		log.info("Filter members by first name ");
		if(members == null || members.isEmpty()) {
			log.info("No records found!");
			throw new ApplicationException("No matching records found !");
		}
		return  members;
	}

	@Override
	public List<Member> findByLastName(String lastName) {
		
		List<Member> members = dao.findByLastName(lastName);
		log.info("Filter members by last name ");
		if(members == null || members.isEmpty()) {
			log.info("No records found!");
			throw new ApplicationException("No matching records found !");
		}
		return  members;
	}


}
