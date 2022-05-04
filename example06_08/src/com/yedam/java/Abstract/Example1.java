package com.yedam.java.Abstract;

public class Example1 {

	public static void main(String[] args) {
		/*
		 문제1) 원을 표현하는 다음 Circle 클래스가 있다. 
		 	   Circle 클래스를 상속받은 NamedCircle 클래스를 작성하여, 다음 main()을 실행할 때 다음 실행 결과와 같이 출력되도록 하라.
		 	   - class Circle {
					private int radius;
					public Circle(int radius) {
						this.radius = radius;
					}
					public int getRadius() {
					return radius;
					}
				}
				
				- 실행코드
				public static void main(String[] args) {
					NamedCircle w = new NamedCircle(5, "Waffle");
					w.show();
				}
				
				- 실행결과
				Waffle, 반지름 = 5
		*/
		NamedCircle w = new NamedCircle(5, "Waffle");
		w.show();
		
		
	}

}
