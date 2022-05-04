package com.yedam.java.Class;

public class SalaryMan {
	//필드
	private int salary;		//월 급여액
	
	//생성자
	/*클래스이름(매개변수, ...){
	 
	 }*/
	SalaryMan(){
		salary = 1000000;
	}
	
	SalaryMan(int salary){
		this.salary = salary;
	}
	
	//메서드
	/*
	리턴타입 메서드이름(매개변수,...) {
		실행구문
	}*/
	
	int getAnnualGross() {
		int salarys = 0;
		salarys = salary * 12 + salary * 5;
		return salarys;
	}
	
	
	
	
	
	
	
}
