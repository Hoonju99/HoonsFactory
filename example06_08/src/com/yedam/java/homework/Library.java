package com.yedam.java.homework;

import java.util.ArrayList;
import java.util.List;

public class Library {
	//필드
	private List<Book> list;
	
	//생성자
	public Library() {
		list = new ArrayList<Book>();
	}
	
	//메서드
	//책 정보 입력
	public void addBook(String name, String writer) {
		list.add(new Book(name, writer));
	}
	
	//책 정보 전체출력
	public void printBookList() {
		System.out.println("책번호  책제목  저자명  대여여부");
		for(Book book : list) {
			System.out.println(book.getBookNo() + " " 
							+ book.getBookName() + " "
							+ book.getBookWriter() + " " 
							+ (book.isRental() ? "대여중" : "대여가능"));
		}
	}
	
	//책 정보 단건출력
	public void selectBookInfo(String name) {
		System.out.println("책번호  책제목  저자명  대여여부");
		for(Book book : list) {
			if(book.getBookName().equals(name)) {
				System.out.println(book.getBookNo() + " " 
						+ book.getBookName() + " "
						+ book.getBookWriter() + " " 
						+ (book.isRental() ? "대여중" : "대여가능"));
			}
		}
	}
	
	//책 대여
	public void rentalBook(String name) {
		for(Book book : list) {
			if(book.getBookName().equals(name)) {
				if(book.isRental()) {
					System.out.println("해당 책은 대여중입니다.");
				}else {
					book.setRental(true);
					System.out.println("대여되었습니다.");
				}
			}
		}
	}
	
	//책 반납
	public void returnBook(String name) {
		for(Book book : list) {
			if(book.getBookName().equals(name)) {
				book.setRental(false);
				System.out.println("반납되었습니다.");
			}
		}
	}
	
}
