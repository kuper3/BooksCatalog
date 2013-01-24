package com.github.kuper3.bookscatalog.ejb.dao;

import java.util.List;

import javax.ejb.Remote;

import com.github.kuper3.bookscatalog.ejb.entity.Author;

@Remote
public interface AuthorBeanRemote {

	void saveOrUpdate(Author obj);

	void remove(Author obj);

	List<Author> getAll();

}
