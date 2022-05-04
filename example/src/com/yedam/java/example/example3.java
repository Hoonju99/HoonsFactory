package com.yedam.java.example;

import java.util.Scanner;

public class example3 {

	public static void main(String[] args) {
		// 1부터 10사이의 임의의 숫자를 발생시킵니다.
		// 총 3번의 기회가 있고
		// 기회 내에 미성공 시 프로그램 종료
		int anwser = (int)(Math.random() * 10) + 1;
		Scanner scanner = new Scanner(System.in);
		
		int chance = 0;
		while(true) {
			System.out.println("1~10 중 원하는 값을 입력하세요.");
			int selected = scanner.nextInt();
			chance++;
			
			if(selected < anwser) {
				System.out.println("up!");
			}else if(selected > anwser) {
				System.out.println("down!");
			}else {
				System.out.println("맞췄습니다.");
				break;
			}
			
			if(chance == 3) {
				System.out.println("기회가 모두 소진되었습니다.");
				break;
			}
		}
	}

}