package com.yedam.java.Class;

public class StudentScores {
	//필드
	private String name;
	private int grade;
	private int korean;
	private int english;
	private int math;
	
	//생성자
	public StudentScores(String name, int grade) {
		this.name = name;
		this.grade = grade;
	}

	
	//메서드	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getKorean() {
		return korean;
	}

	public void setKorean(int korean) {
		this.korean = korean;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}
	
	public int getTotal() {
		/*
		int total = 0;
		total = korean + english + math;
		return total;
		*/
		return korean + english + math;
	}
	
	public double getAverage() {
		return (double) getTotal() / 3;
	}

}
