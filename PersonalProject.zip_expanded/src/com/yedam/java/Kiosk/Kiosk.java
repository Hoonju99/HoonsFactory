package com.yedam.java.Kiosk;

public class Kiosk {
	private int id;
	private int pw;
	private int menuNo;
	private String menuName;
	private int price;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public int getMenuNo() {
		return menuNo;
	}
	public void setMenuNo(int menuNo) {
		this.menuNo = menuNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "ID : " + id + "PW : " +  pw + "메뉴번호 : " + menuNo + "메뉴이름 : " + menuName + "가격 : " + price ;
	}
	
	
	
	
	
	
	
}
