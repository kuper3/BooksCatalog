package com.github.kuper3.bookscatalog.web.faces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;

import com.github.kuper3.bookscatalog.ejb.dao.AuthorBeanLocal;
import com.github.kuper3.bookscatalog.ejb.entity.Author;
import com.github.kuper3.bookscatalog.ejb.entity.key.AuthorName;

public class Authors {
	
	@EJB
	private AuthorBeanLocal authorBean;

	private List<Author> list = new ArrayList<Author>();

	public Authors() {
		Author author = new Author();
		author.setName(new AuthorName("1", "1"));
		
		list.add(author);
	}

	public List<Author> getList() {
		if (list.size() < 2) {
			list.addAll(authorBean.getAll());
		}
		return list;
	}

	public void setList(List<Author> list) {
		this.list = list;
	}

}
