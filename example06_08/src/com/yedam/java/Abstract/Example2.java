package com.yedam.java.Abstract;

public class Example2 {

	public static void main(String[] args) {
		/*
		
		  문제2) 다음 코드와 실행 결과를 참고하여 추상 클래스 Calculator를 상속받는 Adder와 Subtracter 클래스를 작성하라.
		  		- abstract class Calculator {
					protected int a, b;
					abstract protected int calc();
					protected void input() {
						Scanner scanner = new Scanner(System.in);
						System.out.print("정수 2개를 입력하세요 >> ");
						a = scanner.nextInt();
						b = scanner.nextInt();
					}
					public void run() {
						input();
						int res = calc();
						System.out.println("계산된 값은 " + res);
					}
				}
				
				- 실행결과
				1)
				정수 2개를 입력하세요 >> 5 3
				계산된 값은 8
				
				2)
				정수 2개를 입력하세요 >> 3 5
				계산된 값은 -2
	*/
		Calculator calc = new Adder();
		calc.run();
		calc = new Subtracter();
		calc.run();
	}

}
