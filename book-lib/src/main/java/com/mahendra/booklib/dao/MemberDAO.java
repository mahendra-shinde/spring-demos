package com.mahendra.booklib.dao;

import java.util.List;

import com.mahendra.booklib.models.Member;

/**
 * @author mahendra shinde (MahendraShinde@synergetics-india.com
 *
 */
public interface MemberDAO {

	Member findById(Integer id);
	List<Member> findByFirstName(String firstName);
	List<Member> findByLastName(String lastName);
	
	void update(Member Member);
	Integer save(Member Member);
	
}
