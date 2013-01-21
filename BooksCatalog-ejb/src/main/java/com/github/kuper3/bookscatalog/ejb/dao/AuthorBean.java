package com.github.kuper3.bookscatalog.ejb.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.github.kuper3.bookscatalog.ejb.entity.Author;

/**
 * Session Bean implementation class AuthorBean
 */
@Stateless
public class AuthorBean implements AuthorBeanRemote, AuthorBeanLocal {

	@PersistenceContext(unitName="BooksCatalog-ejb")
    private EntityManager em;

	//@Override
	public void saveOrUpdate(Author obj) {
		em.persist(obj);
	}

	//@Override
	public void remove(Author obj) {
		em.remove(obj);
	}
	
	//@Override
	@SuppressWarnings("unchecked")
	public List<Author> getAll() {
		Query query = em.createNativeQuery("select * from authors", Author.class);
		List<Author> result = query.getResultList();
		return result;
	}

}
