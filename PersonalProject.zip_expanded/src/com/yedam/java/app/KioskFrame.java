package com.yedam.java.app;

import java.util.List;
import java.util.Scanner;


import com.yedam.java.Kiosk.Kiosk;
import com.yedam.java.Kiosk.KioskDAO;
import com.yedam.java.Kiosk.KioskDAOImpl;


public class KioskFrame {

	private Scanner sc = new Scanner(System.in);
	private KioskDAO dao = KioskDAOImpl.getinstance();
	
	public void run() {
		while(true) {
			
			menuPrint();
			
			int menuNo = menuSelect();
			
			if(menuNo == 1) {
				//아이디 만들기
				
			} else if (menuNo == 2) {
				//menu 등록
				insertKiosk();
			} else if (menuNo == 3) {
				//menu 수정
				updateKiosk();
			} else if (menuNo == 4) {
				//menu 삭제
				deleteKioskNo();
			} else if (menuNo == 5) {
				//menu 전체조회 -> menuNo menuName price
				selectAll();
			} else if (menuNo == 9) {
				
				break;
			}
		}
	}

	public void menuPrint() {
		System.out.println();
		System.out.println("======================================================");
		System.out.println("1.ID생성 | 2.메뉴등록 | 3.메뉴수정 | 4.메뉴삭제 | 5.메뉴조회 | 9.종료");
		System.out.println("======================================================");
		System.out.print("선택>");
	}
	
	
	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = sc.nextInt();
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다.");
		}
		return menuNo;
	}
	
	
	public void insertKiosk() {
		Kiosk kio = inputKioskInfo();
		dao.insert(kio);
	}

	private Kiosk inputKioskInfo() {
		
		Kiosk kio = new Kiosk();
		System.out.println("메뉴넘버>");
		kio.setMenuNo(sc.nextInt());
		System.out.println("메뉴이름>");
		kio.setMenuName(sc.next());
		System.out.println("가격>");
		kio.setPrice(sc.nextInt());
		
		return kio;
		
	}
	
	
	public void updateKiosk() {
		Kiosk kio = inputKioskContent();
		dao.update(kio);
	}
	
	public Kiosk inputKioskContent() {
		Kiosk kio = new Kiosk();
		
		System.out.println("메뉴넘버>");
		kio.setMenuNo(sc.nextInt());
		System.out.println("메뉴이름>");
		kio.setMenuName(sc.next());
		System.out.println("가격>");
		kio.setPrice(sc.nextInt());
		
		return kio;
	}
	
	public void selectAll() {
		List<Kiosk> list = dao.selectAll();
		for(Kiosk kio : list) {
			System.out.println(kio);
		}
	}
	
	public void deleteKioskNo() {
		int menuNo = inputMenuNo();		
		dao.delete(menuNo);
	}
	
	public int inputMenuNo() {
		System.out.println("메뉴넘버>");
		int MenuNo = sc.nextInt();
		return MenuNo;
	}
	
}
