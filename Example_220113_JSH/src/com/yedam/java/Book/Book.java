package com.yedam.java.Book;

public class Book {
	private String name;
	private String writer;
	private String content;
	private boolean rental;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean getRental() {
		return rental;
	}
	public void setRental(boolean rental) {
		this.rental = rental;
	}
	@Override
	public String toString() {
		return "책이름 : " + name + ", 저자명 :" + writer + ", 내용 : " + content + ", 대여여부 " + rental ;
	}
	
	
	
}
