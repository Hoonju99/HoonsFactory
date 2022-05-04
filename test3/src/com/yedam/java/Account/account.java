package com.yedam.java.Account;

public class account {
	private int account_no;
	private String account_owner;
	private String account_password;
	private int account_balance;
	
	
	
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public String getAccount_owner() {
		return account_owner;
	}
	public void setAccount_owner(String account_owner) {
		this.account_owner = account_owner;
	}
	public String getAccount_password() {
		return account_password;
	}
	public void setAccount_password(String account_password) {
		this.account_password = account_password;
	}
	public int getAccount_balance() {
		return account_balance;
	}
	public void setAccount_balance(int account_balance) {
		this.account_balance = account_balance;
	}
	
	
	
	
	@Override
	public String toString() {
		return "account [account_no=" + account_no + ", account_owner=" + account_owner + ", account_password="
				+ account_password + ", account_balance=" + account_balance + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
