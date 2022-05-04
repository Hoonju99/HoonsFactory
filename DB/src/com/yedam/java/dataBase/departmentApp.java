package com.yedam.java.dataBase;

import java.util.Scanner;

public class departmentApp {

	public static void main(String[] args) {
		
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		DepartmentDao dao = dpartmentDao.getInstance();
		
		department dept = null;
		int departmentID = 0;
		
		while(run) {
			System.out.println();
			System.out.println("1.2.3.4.5.9");
			System.out.println("선택");
			int menuNo = Integer.parseInt(sc.next());
			
			switch(menuNo) {
			
			}
			
		}
		
		
	}

}
