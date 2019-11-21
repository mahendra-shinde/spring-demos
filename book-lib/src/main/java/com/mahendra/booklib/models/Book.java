package com.mahendra.booklib.models;

import javax.persistence.*;

@Entity
@Table(name="books")
public class Book {
	
	@Id
	@Column(name="id")
	@SequenceGenerator(name="gen1",sequenceName="book_seq",initialValue=10000,allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="gen1")
	private Integer id;
	
	@Column(name="title",length=20)
	private String title;
	
	@Column(name="author",length=20)
	private String author;
	
	@Column(name="category",length=20)
	private String category;
	
	@Column(name="status",length=1)
	private char status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Book(String title, String author, String category, char status) {
		super();
		this.title = title;
		this.author = author;
		this.category = category;
		this.status = status;
	}
	public Book() {
		super();
	}
	
}
