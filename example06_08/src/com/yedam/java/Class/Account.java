package com.yedam.java.Class;

public class Account {
	//필드
	private String owner;
	private int balance;
	
	//생성자
	public Account(String owner) {
		this.owner = owner;
	}
	
	//메서드
	public String getOwner() {
		return owner;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
		this.balance += money;
	}
	
	public void withdraw(int money) {
		this.balance -= money;
	}

	
}
