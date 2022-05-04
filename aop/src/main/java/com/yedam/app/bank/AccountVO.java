package com.yedam.app.bank;

import lombok.Data;

@Data
public class AccountVO {
	
	String account_holder_name;
	String bank_name;
	String account_num_masked;
	String fintech_use_num;
	String account_alias;
	
}
