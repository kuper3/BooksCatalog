package com.github.kuper3.bookscatalog.ejb.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.github.kuper3.bookscatalog.ejb.entity.key.AuthorName;

@Entity
@Table(name="authors")
public class Author implements Serializable {

	private static final long serialVersionUID = 901911048049938464L;

	@EmbeddedId
	private AuthorName name;
	
	@ManyToMany
	private List<Book> books;

	public AuthorName getName() {
		return name;
	}

	public void setName(AuthorName name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Author [name=");
		builder.append(name);
//		builder.append(", books=");
//		for(Book b: books) {
//			builder.append(b.getIsbn() + " ");
//		}
		builder.append("]");
		return builder.toString();
	}	

}
