package com.github.kuper3.bookscatalog.ejb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="books")
public class Book implements Serializable {

	private static final long serialVersionUID = -4507633746397878138L;

	@Id
	private String isbn;
	
	private String name;
	
	@ManyToMany
	private List<Author> authors;
	
	@Column(name = "year_published")
	private int yearPublished;
	
	private String publisher;

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(List<Author> authors) {
		this.authors = authors;
	}

	public int getYearPublished() {
		return yearPublished;
	}

	public void setYearPublished(int year_published) {
		this.yearPublished = year_published;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return isbn + "\t" + name + "\t" + authors + "\t" + yearPublished + "\t" + publisher;
	}

}
