package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.User.User;
import com.yedam.java.User.UserDAOImpl;

public class MainExample {

	public Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		boolean run = true;

		while (true) {

			menuPrint();

			int menuNo = menuSelect();

			if (menuNo == 1) {
				insertUser();
			} else if (menuNo == 2) {
				loginUser();
			} else if (menuNo == 3) {
				end();
				break;
			}

		}
	}

	public static void menuPrint() {
		System.out.println();
		System.out.println("====================================================");
		System.out.println("1.회원가입 | 2.로그인 | 3.종료");
		System.out.println("====================================================");
		System.out.println("선택>");

	}

	public static int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다.");
		}
		return menuNo;
	}

	public static void insertUser() {
		User user = inputUserInfo();

		UserDAOImpl.getInstance().insert(user);
	}

	public static void loginUser() {
		User user = inputLoginInfo();
		User loginUser = UserDAOImpl.getInstance().selectUserInfo(user);
		if (loginUser == null) {
			System.out.println("회원정보를 확인해주세요.");
		} else if (loginUser.getAuth() == 0) {
			// 관리자일때 실행하는 메뉴
			new KioskFrame().run();
		} else if (loginUser.getAuth() == 1) {
			// 일반회원일떄 실행하는 메뉴
		}
	}

}
