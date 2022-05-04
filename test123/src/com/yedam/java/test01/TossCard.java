package com.yedam.java.test01;

public class TossCard extends Card {
	private String company;
	private String cardStaff;
	
	public TossCard(String cardNo, int validDate, int cvc, String cardSaff) {

		
		super(cardNo, validDate, cvc);
		
		this.company = "Toss";
		
		
	}

}
