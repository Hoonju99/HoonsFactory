package com.yedam.java.homework;

import java.util.Scanner;

public class Example_Library {

	public static void main(String[] args) {
		boolean run = true;
		Scanner scanner = new Scanner(System.in);

		Library library = new Library();
		String name = null;

		while (run) {
			System.out.println("=== 1.책정보 입력 | 2.전체조회 | 3.단건조회 | 4.책 대여 | 5.책 반납 | 6.종료 ===");
			System.out.print("선택>");

			int menuNo = Integer.parseInt(scanner.nextLine());

			switch (menuNo) {
			case 1:
				System.out.print("책제목>");
				name = scanner.nextLine();
				System.out.print("저자명>");
				String writer = scanner.nextLine();
				library.addBook(name, writer);
				break;
			case 2:				
				library.printBookList();
				break;
			case 3:
				System.out.print("책제목>");
				name = scanner.nextLine();
				library.selectBookInfo(name);
				break;
			case 4:
				System.out.print("책제목>");
				name = scanner.nextLine();
				library.rentalBook(name);
				break;
			case 5:
				System.out.print("책제목>");
				name = scanner.nextLine();				
				library.returnBook(name);
				break;
			case 6:
				run = false;
				System.out.println("프로그램 종료");
				break;
			}
		}

	}

}
