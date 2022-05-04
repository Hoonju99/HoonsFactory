package com.yedam.java.Account;

import java.util.List;

public interface AccountDAO {

	public List<account> selectAll();
	
	public account selectOne(int account_no);
	
	public void insert(account account_owner);
	
	public void update(account account_owner);
	
	public void delete(int accound_no);
	
}
