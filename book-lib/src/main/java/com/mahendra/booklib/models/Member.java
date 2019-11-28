package com.mahendra.booklib.models;

import javax.persistence.*;

@Entity
@Table(name="members")
public class Member {
	
	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="gen1",sequenceName="member_seq",initialValue=10000,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen1")
	private Integer id;
	
	@Column(name="fname",length=25)
	private String firstName;
	
	@Column(name="lname",length=25)
	private String lastName;
	
	@Column(name="status",length=1)
	private String status;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Member(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.status = "A";
	}
	public Member() {
		super();
	}
	
}
