package com.yedam.java.example;

import java.util.Scanner;

public class example {

	public static void main(String[] args) {

		// 커피메뉴 4개와 각 가격을 출력하고
		// 사용자가 메뉴를 선택한 만큼 가격을 합산해서 출력

		// 메뉴를 출략

		// 사용자가 선택하는 부분

		// 선택한 메뉴에 따라 가격을 합산

		boolean run = true;
		Scanner scanner = new Scanner(System.in);

		int sum = 0;
		String bill = "*** 영수증 ***\n	";
		while (run) {
			System.out.println("*** 커피 메뉴 ***\n");
			System.out.println("1아메리카노 2000원\n");
			System.out.println("2카페라떼 3500원\n");
			System.out.println("3카라멜 마끼아또 5000원\n");
			System.out.println("4자바칩 프라프치노 6500원\n");
			System.out.println("5프로그램 종료");

			int menuNO = scanner.nextInt();

			switch (menuNO) {
			case 1:
				sum += 2000;
				bill += "아메리카노 2000원\n";
				break;
			case 2:
				sum += 3500;
				bill += "카페라떼 3500\n";
				break;
			case 3:
				sum += 5000;
				bill += "카라멜 마끼아또 5000원\n";
				break;
			case 4:
				sum += 6500;
				bill += "자바칩 프라프치노 6500\n";
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("잘못된 선택입니다.다시 선택해 주세요");
			}

		}
		bill += "----------------------------\n";
		bill += "총 합계 : " + sum + "원";
		System.out.println(bill);

	}

}
