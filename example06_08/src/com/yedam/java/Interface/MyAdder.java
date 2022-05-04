package com.yedam.java.Interface;

public class MyAdder implements AdderInterface {

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x + y;
	}

	@Override
	public int add(int n) {
		int sum = 0;
		for(int i = 1; i<=n; i++) {
			sum += i;
		}
		return sum;
	}

}
