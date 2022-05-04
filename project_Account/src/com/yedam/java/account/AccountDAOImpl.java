package com.yedam.java.account;

import java.sql.SQLException;

import com.yedam.java.common.DAO;

public class AccountDAOImpl extends DAO implements AccountDAO {
	private static AccountDAO instance = new AccountDAOImpl();
	private AccountDAOImpl() {}
	public static AccountDAO getInstance() {
		return instance;
	}

	@Override
	public Account selectAccountInfo(long accounNo) {
		Account account = null;
		try {
			connect();
			String select = "SELECT * FROM account WHERE account_no = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setLong(1, accounNo);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				account = new Account();
				account.setAccountNo(rs.getLong("account_no"));
				account.setAccountOwner(rs.getString("account_owner"));
				account.setAccountPassword(rs.getString("account_password"));
				account.setAccountBalance(rs.getLong("account_balance"));
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return account;
	}

	@Override
	public long selectAccountNo(Account account) {
		long accountNo = 0;
		try {
			connect();
			String select ="SELECT account_no FROM account WHERE account_owner = ? AND account_password = ? ORDER BY account_no DESC";
			pstmt = conn.prepareStatement(select);
			pstmt.setString(1, account.getAccountOwner());
			pstmt.setString(2, account.getAccountPassword());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				accountNo = rs.getLong("account_no");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return accountNo;
	}

	@Override
	public void createAccount(Account account) {
		try {
			connect();
			String insert = "INSERT INTO account (account_owner, account_password, account_balance) VALUES(?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setString(1, account.getAccountOwner());
			pstmt.setString(2, account.getAccountPassword());
			pstmt.setLong(3, account.getAccountBalance());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("계좌가 정상적으로 개설되었습니다.");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();			
		}
	}

	@Override
	public void updateAccount(Account account) {
		try {
			connect();
			String update = "UPDATE account SET account_balance = account_balance + ? WHERE account_no = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setLong(1, account.getAccountBalance());
			pstmt.setLong(2, account.getAccountNo());
			
			int result = pstmt.executeUpdate();
			
			if(result > 0) {
				System.out.println("정상적으로 처리되었습니다.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

}
