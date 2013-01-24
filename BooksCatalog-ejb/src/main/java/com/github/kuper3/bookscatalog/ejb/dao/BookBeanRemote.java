package com.github.kuper3.bookscatalog.ejb.dao;

import java.util.List;

import javax.ejb.Remote;

import com.github.kuper3.bookscatalog.ejb.entity.Author;
import com.github.kuper3.bookscatalog.ejb.entity.Book;

@Remote
public interface BookBeanRemote {

	void saveOrUpdate(Book obj);

	void remove(Book obj);

	List<Book> get(Author obj);

	List<Book> getAll();

}
