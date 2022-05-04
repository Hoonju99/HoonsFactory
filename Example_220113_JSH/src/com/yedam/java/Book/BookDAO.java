package com.yedam.java.Book;

import java.util.List;

public interface BookDAO {
	
	public List<Book> selectAll();
	
	public Book selectOne(String name);
	
	public void insert(Book  book);
	
	
	public void updateBook(Book rental);
	
	
}
