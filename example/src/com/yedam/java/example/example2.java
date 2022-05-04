package com.yedam.java.example;

import java.util.Scanner;

public class example2 {

	public static void main(String[] args) {
		// ATM기가 있고 입급, 출금 ,잔액조회,종료
		// 1. 출금을 할때 잔액보다 많을 경우 잔액부족
		// 2. 입금,출급,잔액조회 -> 비밀번호로 정보확인

		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------");
			System.out.print("선택>");
			int menuNo = Integer.parseInt(scanner.nextLine());

			if (menuNo == 4) {
				run = false;
				continue;
			}

			System.out.println("비밀번호를 입력하세요.");
			int password = Integer.parseInt(scanner.nextLine());

			if (password == 1234) {
				switch (menuNo) {
				case 1:// 예금
					System.out.print("예금액>");
					balance += Integer.parseInt(scanner.nextLine());
					break;
				case 2:// 출금
					System.out.print("출금액>");
					int num = Integer.parseInt(scanner.nextLine());
					if (num > balance) {
						System.out.println("잔고가 부족합니다.");
					} else {
						balance -= num;
					}
					break;
				case 3:// 잔고
					System.out.println("잔고>" + balance);
					break;
				}
			} else {
				System.out.println("비밀번호를 잘못 입력하셨습니다.");
			}
		}
		System.out.println("프로그램을 종료합니다.");
	}

}