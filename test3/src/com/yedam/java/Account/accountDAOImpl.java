package com.yedam.java.Account;

import java.util.ArrayList;
import java.util.List;



public class accountDAOImpl extends account implements AccountDAO {

	@Override
	public List<account> selectAll() {
		List<account> list = new ArrayList<>();
		try {
		connect();
		String select = "SELECT * FROM ACCOUNT ORDER BY account_no";
		pstmt = conn.prepareStatement(select);
		rs = pstmt.executeQuery();
		while (rs.next()) {
		
			
		}
		}
	}

	@Override
	public account selectOne(int account_no) {
		return null;
	}

	@Override
	public void insert(account account_owner) {

	}

	@Override
	public void update(account account_owner) {

	}

	@Override
	public void delete(int accound_no) {

	}

}
