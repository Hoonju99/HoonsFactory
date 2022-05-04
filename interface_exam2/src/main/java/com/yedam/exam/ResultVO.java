package com.yedam.exam;

import java.util.List;

public class ResultVO {
	int total;
	int success;
	List<String> errList;
	
	
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public List<String> getErrList() {
		return errList;
	}
	public void setErrList(List<String> errList) {
		this.errList = errList;
	}
	
	
}
