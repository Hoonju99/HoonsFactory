package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.Kiosk.Kiosk;
import com.yedam.java.User.User;
import com.yedam.java.User.UserDAO;
import com.yedam.java.User.UserDAOImpl;

public class UserFrame {
	private UserDAO dao = UserDAOImpl.getinstance();
	private Scanner sc = new Scanner(System.in);

	public UserFrame() {

		while (true) {
			// 메뉴출력
			menuPrint();

			int menuNo = menuSelect();

			// 각 메뉴별로 기능을 실행
			if (menuNo == 1) {
				insertUser();
			} else if (menuNo == 2) {
				insertUserId();
			} else if (menuNo == 3) {
				end();
				break;
			}
		}

	}
	public void menuPrint() {
		System.out.println();
		System.out.println("=== 1.회원가입  2.로그인  3.종료 ===");
		System.out.print("선택>");
	}
	
	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = sc.nextInt();
		}catch(Exception e) {
			System.out.println("없는 메뉴입니다.");
		}
		return menuNo;
	}
	
	public void insertUserID() {
		User us = inputUsernfo();
		dao.insert(us);
	}
	
private User inputUsernfo() {
		
		User us = new User();
		System.out.println("아이디>");
		us.setId(sc.next());
		System.out.println("비밀번호>");
		us.setPw(sc.next());
		
		return us;
		
	}

	public void end() {
		System.out.println("프로그램 종료");
	}

}