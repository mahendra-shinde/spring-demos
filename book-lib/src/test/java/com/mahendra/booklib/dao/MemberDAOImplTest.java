package com.mahendra.booklib.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mahendra.booklib.models.Member;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:/config/spring-core.xml")
public class MemberDAOImplTest {

	@Autowired private MemberDAO dao;
	
	@Test
	public void testFindById() {
		Member m = dao.findById(20000);
		assertNotNull(m);
	}

	@Test
	public void testFindByLastName() {
		List<Member> members = dao.findByLastName("Hood");
		assertEquals(1, members.size());
	}

}
