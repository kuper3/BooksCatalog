package com.github.kuper3.bookscatalog.web.faces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.component.html.HtmlDataTable;

import com.github.kuper3.bookscatalog.ejb.dao.BookBeanLocal;
import com.github.kuper3.bookscatalog.ejb.entity.Book;

public class BookListController {
	
	@EJB
	private BookBeanLocal bookBean;

	private static final String SUCCESS = "success";
	private static final Book DEFAULT_BOOK = new Book();
	
	private List<Book> books = new ArrayList<Book>();

	private HtmlDataTable dataTable;

	private Book selectedBook = DEFAULT_BOOK;
	private int selectedBookIndex = 0;
	
	public BookListController() {
		List<Book> list = null;
		if (bookBean != null) {
			list = bookBean.getAll();
		}
		if (list == null || list.isEmpty()) {
			Book book1 = new Book();
			book1.setIsbn("1111111111111");
			book1.setName("Book1");
			book1.setYearPublished(2011);

			Book book2 = new Book();
			book2.setIsbn("2222222222222");
			book2.setName("Book2");
			book2.setYearPublished(2012);

			books.add(book1);
			books.add(book2);
		} else {
			books.addAll(list);
		}

		sortBooks();
	}
	
	private void sortBooks() {
		Collections.sort(books, new Comparator<Book>() {

			public int compare(Book b1, Book b2) {
				return b1.getIsbn().compareToIgnoreCase(b2.getIsbn());
			}
		});
	}
	

	// Add button event on modal panel
	public String addNewBook() {
		System.out.println("new book added: " + selectedBook);
		books.add(selectedBook);
		selectedBook = DEFAULT_BOOK;		
		sortBooks();		
		return SUCCESS;
	}

	// delete button event
	public String onDelete() {
		books.remove(selectedBook);
		System.out.println("size: " + books.size());
		sortBooks();
		return "editDetail";
	}

	// link to detail page
	public String showDetail() {
		selectedBook = (Book) dataTable.getRowData();
		selectedBookIndex = dataTable.getRowIndex();
		
		assert(books.get(selectedBookIndex).equals(selectedBook));
		
		return "detail";
	}
	
	// save on detail page
	public String onSave() {
		books.remove(selectedBookIndex);
		books.add(selectedBook);
		
		sortBooks();
		
		return "editDetail";
	}
	
	public String onCancel() {
		return "editDetail";
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public Book getSelectedBook() {
		return selectedBook;
	}

	public void setSelectedBook(Book selectedBook) {
		this.selectedBook = selectedBook;
	}

}
