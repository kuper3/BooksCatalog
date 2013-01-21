package com.github.kuper3.bookscatalog.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Hibernate;

import com.github.kuper3.bookscatalog.ejb.entity.Author;
import com.github.kuper3.bookscatalog.ejb.entity.Book;

/**
 * Session Bean implementation class BookBeanImpl
 */
@Stateless
public class BookBean implements BookBeanLocal, BookBeanRemote {
	
	@PersistenceContext(unitName="BooksCatalog-ejb")
	private EntityManager em;

	//@Override
	public void saveOrUpdate(Book obj) {
		em.persist(obj);
	}

	//@Override
	public void remove(Book obj) {
		em.remove(obj);
		
	}

	//@Override
	@SuppressWarnings("unchecked")
	public List<Book> get(Author obj) {		
		Query query = em.createNativeQuery("select * from books inner join authors_books where authors_first_name= :firstName and authors_second_name= :secondName", Book.class);
		query.setParameter("firstName", obj.getName().getFirstName());
		query.setParameter("secondName", obj.getName().getSecondName());
		List<Book> result = query.getResultList();
		return result;
	}

	//@Override
	@SuppressWarnings("unchecked")
	public List<Book> getAll() {
		Query query = em.createNativeQuery("select * from books", Book.class);
		List<Book> result = query.getResultList();
		for(Book book : result) {
			Hibernate.initialize(book.getAuthors());
		}
		return result;
	}

}
