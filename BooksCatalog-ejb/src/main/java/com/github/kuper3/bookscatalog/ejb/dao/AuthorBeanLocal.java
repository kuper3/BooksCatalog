package com.github.kuper3.bookscatalog.ejb.dao;

import java.util.List;

import javax.ejb.Local;

import com.github.kuper3.bookscatalog.ejb.entity.Author;


@Local
public interface AuthorBeanLocal {
	
	void saveOrUpdate(Author obj);
	void remove(Author obj);
	List<Author> getAll();

}
