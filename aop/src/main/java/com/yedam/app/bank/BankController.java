package com.yedam.app.bank;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankController {

	

	@GetMapping("/balanceInfo")
	public  long balanceInfo(BankVO vo) {
		return BankAPI.getBalanceInfo(vo);
	}

	@GetMapping("/accountList")
	public List<AccountVO> accountList(BankVO vo) {
		return BankAPI.getAccountList(vo);
	}

	@GetMapping("/getTransaction")
	public  Map getTransaction(BankVO vo) {
		return BankAPI.getTransaction(vo);
	}
	
	@GetMapping("/updateInfo")
	public  Map updateInfo(BankVO vo) {
			return BankAPI.updateInfo(vo);
	}

	@GetMapping("/getRealName")
	public void getRealName() {
		String str = BankAPI.getRealName();
		System.out.println(str);
	}
}
