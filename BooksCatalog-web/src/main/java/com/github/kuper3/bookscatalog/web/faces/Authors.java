package com.github.kuper3.bookscatalog.web.faces;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import com.github.kuper3.bookscatalog.ejb.dao.AuthorBeanLocal;
import com.github.kuper3.bookscatalog.ejb.entity.Author;
import com.github.kuper3.bookscatalog.ejb.entity.key.AuthorName;
import com.github.kuper3.bookscatalog.util.Version;

public class Authors {	
	
	private AuthorBeanLocal authorBean;

	private List<Author> list = new ArrayList<Author>();

	public Authors() {
		
		/*
		 * Looks like @Ejb doesnt work properly with jsf 1.2. 
		 */
		try {
			InitialContext context = new InitialContext();
			authorBean = (AuthorBeanLocal) context.lookup("BooksCatalog-ear-" + Version.VALUE + "/AuthorBean/local");			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		Author author = new Author();
		author.setName(new AuthorName("1", "1"));
		
		list.add(author);
		System.out.println("AuthorBean = " + authorBean);
		if (authorBean != null) {
			list.addAll(authorBean.getAll());
		}
	}

	public List<Author> getList() {
		return list;
	}

	public void setList(List<Author> list) {
		this.list = list;
	}

}
