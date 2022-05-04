package com.yedam.java.Abstract;

public class Example3 {

	public static void main(String[] args) {
/*
		문제3) 다음은 단위를 변환하는 추상 클래스 Converter이다.
			  Converter 클래스를 상속받아 원화를 달러로 변환하는 Won2Dollar 클래스를 작성하라. 
			  main() 메소드와 실행 결과는 다음과 같다.
			  - abstract class Converter {
   					abstract protected double convert(double src); // 추상 메소드
   					abstract protected String getSrcString(); // 추상 메소드
   					abstract protected String getDestString(); // 추상 메소드
   					protected double ratio; // 비율
   					public void run() {
      					Scanner scanner = new Scanner(System.in);
      					System.out.println(getSrcString()+"을 "+getDestString()+"로 바꿉니다.");
      					System.out.print(getSrcString()+"을 입력하세요>> ");
      					double val = scanner.nextDouble();
      					double res = convert(val);
      					System.out.println("변환 결과: "+res+getDestString()+"입니다");
      					scanner.close();
  					 }
					}
				
				- 실행코드
				public static void main(String args[]) {
   					Won2Dollar toDollar = new Won2Dollar(1200); // 1달러는 1200원
   					toDollar.run();
				}
				
				- 실행결과
				원을 달러로 바꿉니다.
				원을 입력하세요>> 24000
				변환 결과: 20.0달러입니다
*/
		Won2Dollar toDollar = new Won2Dollar(1200); // 1달러는 1200원
		toDollar.run();

	}

}
