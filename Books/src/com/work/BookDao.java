package com.work;


import java.util.List;

public interface BookDao {
	public boolean insertBook(Book book);
	public List<Book> listAllBooks();
	
	public boolean updateBook(Book book);
	public Book getBook(int id);
	public boolean deleteBook(Integer id);
		
	
}
