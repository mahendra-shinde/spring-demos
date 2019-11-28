package com.mahendra.booklib.services;

import java.util.List;

import com.mahendra.booklib.models.Member;

/**
 * @author mahendra shinde (MahendraShinde@synergetics-india.com
 *
 */
public interface MemberService {
	public void updateStatus(int memberId, String newStatus);
	public int save(Member member);
	public Member findById(int memberId);
	public List<Member> findByFirstName(String firstName);
	public List<Member> findByLastName(String lastName);
	
}
