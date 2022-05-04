package com.yedam.java.Book;

import java.sql.SQLException;		
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class BookDaoImpl extends DAO implements BookDAO {
	private static BookDAO instance = new BookDaoImpl();
	private BookDaoImpl() {}
	public static BookDAO getInstance() {
		return instance;
	}
	
	
	
	
	@Override
	public List<Book> selectAll() {
		List<Book> list = new ArrayList<>();
		try {
			connect();
			String select = "SELECT * FROM book ORDER BY book_name";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setName(rs.getString("book_name"));
				book.setWriter(rs.getString("book_writer"));
				book.setContent(rs.getNString("book_content"));
				book.setRental(rs.getBoolean("book_rental"));
				
				list.add(book);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public Book selectOne(String name) {
		Book book = null;
		try {
			connect();
			String select = "SELECT * FROM employees WHERE Book_name = ?","SELECT * FROM employees WHERE Book_name = ?","SELECT * FROM employees WHERE Book_name = ?","SELECT * FROM employees WHERE Book_name = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new Book();
				
				book.setName(rs.getString("book_name"));
				book.setWriter(rs.getString("book_writer"));
				book.setContent(rs.getNString("book_content"));
				book.setRental(rs.getBoolean("book_rental"));
				
				
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return book;
	}
	@Override
	public void insert(Book book) {
		try {
			connect();
			String insert = "INSERT INTO book VALUES (?,?,?,?) ";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1,book.getName());
			pstmt.setString(2, book.getWriter());
			pstmt.setString(3, book.getContent());
			pstmt.setBoolean(4, book.getRental());
			
			
			int result =  pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
		
		
		
		
		
	}


	@Override
	public void updateBook(Book book) {
		try {
			connect();
			String update = "UPDATE book SET rental = ? WHERE employee_id = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setBoolean(1,book.getRental());
			pstmt.setString(2, book.getName());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "");
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
