package com.yedam.app;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.yedam.app.bank.AccountVO;
import com.yedam.app.bank.BankAPI;
import com.yedam.app.bank.BankVO;

public class BankTest {

	//@Test
	public void getTransaction() {
		BankVO vo = new BankVO();
		Map tran = BankAPI.getTransaction(vo);
		System.out.println(tran);		
	}

	//@Test
	public void getRealName() {
		String str = BankAPI.getRealName();
		// assertEquals(name, "이홍제");
		System.out.println(str);
	}

	//@Test
	public void getBalance() {
		BankVO vo = new BankVO();
		long balance = BankAPI.getBalanceInfo(vo);
		System.out.println(balance);
	}
	
	//@Test
	public void getAccountList() {
		BankVO vo = new BankVO();
		List<AccountVO> list  = BankAPI.getAccountList(vo);
		System.out.println(list);
	}
	
	//@Test
	public void updateInfo() {
		BankVO vo = new BankVO();
		Map str = BankAPI.updateInfo(vo);
	}

}
