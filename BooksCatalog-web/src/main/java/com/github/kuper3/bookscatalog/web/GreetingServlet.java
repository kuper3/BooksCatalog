package com.github.kuper3.bookscatalog.web;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.kuper3.bookscatalog.ejb.HelloService;
import com.github.kuper3.bookscatalog.ejb.dao.BookBeanLocal;
import com.github.kuper3.bookscatalog.ejb.entity.Book;

/**
 * Greeting servlet
 */
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private HelloService helloService;
	
	@EJB
	private BookBeanLocal bookBean;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String greeting = helloService.greet(name);
		request.setAttribute("greeting", greeting);

		List<Book> books = bookBean.getAll();
		System.out.println(Arrays.toString(books.toArray()));
		
//		Author author = new Author();
//		author.setName(new AuthorName("A_15", "B"));
//		
//		List<Book> author_books = bookBean.get(author);
//		System.out.println(Arrays.toString(author_books.toArray()));

		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response); //$NON-NLS-1$
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
