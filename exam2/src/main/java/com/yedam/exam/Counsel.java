package com.yedam.exam;

public class Counsel {
	private  Integer  no;   	    //상담번호
	private  String   employee_id; 	//사원번호
	private  String   name;		    //사원명
	private  String   counsel_type;	//상담구분
	private  Integer  dttm;		    //상담시간
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public String getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(String employee_id) {
		this.employee_id = employee_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCounsel_type() {
		return counsel_type;
	}
	public void setCounsel_type(String counsel_type) {
		this.counsel_type = counsel_type;
	}
	public Integer getDttm() {
		return dttm;
	}
	public void setDttm(Integer dttm) {
		this.dttm = dttm;
	}
	
	
}
