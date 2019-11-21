package com.mahendra.booklib.models;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="issues")
public class BookIssue {
	@Id
	@Column(name="id")
	@SequenceGenerator(name="gen1",sequenceName="issue_seq",initialValue=10000,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen1")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="book_id")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	@Temporal(TemporalType.DATE)
	@Column(name="issue_date")
	private Date dateOfIssue;
	
	@Temporal(TemporalType.DATE)
	@Column(name="est_return")
	
	private Date estimatedReturnDate;
	
	// actualReturnDate = NULL  Book not returned yet
	// actualReturnDate != NULL, Book is returned
	@Temporal(TemporalType.DATE)
	@Column(name="act_return")
	private Date actualReturnDate;
	//STATUS = 'P' Book not returned
	//STATUS = 'R' Book has been returned
	
	@Column(name="status",length=1)
	private char status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Date getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(Date dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public Date getEstimatedReturnDate() {
		return estimatedReturnDate;
	}
	public void setEstimatedReturnDate(Date estimatedReturnDate) {
		this.estimatedReturnDate = estimatedReturnDate;
	}
	public Date getActualReturnDate() {
		return actualReturnDate;
	}
	public void setActualReturnDate(Date actualReturnDate) {
		this.actualReturnDate = actualReturnDate;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public BookIssue() {
		super();
	}
	
	public BookIssue(Book book, Member member, Date dateOfIssue, Date estimatedReturnDate) {
		super();
		this.book = book;
		this.member = member;
		this.dateOfIssue = dateOfIssue;
		this.estimatedReturnDate = estimatedReturnDate;
		this.status = 'P';
	}
	
	
}
