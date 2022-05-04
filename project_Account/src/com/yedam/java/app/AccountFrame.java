package com.yedam.java.app;

import java.util.Scanner;

import com.yedam.java.account.Account;
import com.yedam.java.account.AccountDAO;
import com.yedam.java.account.AccountDAOImpl;

public class AccountFrame {
	private Scanner scanner = new Scanner(System.in);
	private AccountDAO dao = AccountDAOImpl.getInstance();

	public void run() {
		while (true) {
			// 메뉴출력
			menuPrint();

			// 메뉴선택
			int menuNo = menuSelect();

			// 각 기능별 실행
			if (menuNo == 1) {
				// 계좌개설
				createAccount();
			} else if (menuNo == 2) {
				// 잔액조회
				selectAccountBalance();
			} else if (menuNo == 3) {
				// 입금
				deposit();
			} else if (menuNo == 4) {
				// 출금
				withdraw();
			} else if (menuNo == 5) {
				// 계좌이체
				transfer();
			} else if (menuNo == 9) {
				// 종료
				end();
				break;
			}
		}
	}

	public void menuPrint() {
		System.out.println();
		System.out.println("======================================================");
		System.out.println("1.계좌개설 | 2.잔액조회 | 3.입금 | 4.출금 | 5.계좌이체 | 9.종료");
		System.out.println("======================================================");
		System.out.print("선택>");
	}

	public int menuSelect() {
		int menuNo = 0;
		try {
			menuNo = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("없는 메뉴입니다.");
		}
		return menuNo;
	}

	// 계좌개설 기능
	public void createAccount() {
		// 계좌개설 정보 입력
		Account account = inputAccountFull();
		// DB에 계좌정보 등록
		dao.createAccount(account);
		// 계좌번호 출력
		System.out.println("계좌번호 : " + dao.selectAccountNo(account));
	}

	// 계좌잔액조회 기능
	public void selectAccountBalance() {
		// 조회할 계좌정보 입력 -> inputAccountInfo()
		// 계좌정보 정확한지 확인 : 계좌번호, 비밀번호 -> checkAccountInfo()
		Account account = checkAccountInfo(inputAccountInfo());
		// 해당 계좌 잔액을 조회
		if (account != null) {
			System.out.println(dao.selectAccountInfo(account.getAccountNo()));
		}
	}

	// 입금
	public void deposit() {
		// 조회할 계좌정보 입력 -> inputAccountInfo()
		// 계좌정보 정확한지 확인 : 계좌번호, 비밀번호 -> checkAccountInfo()
		Account account = checkAccountInfo(inputAccountInfo());

		if (account != null) {
			// 금액이 1원이상인지 확인 -> inputAmount()
			account.setAccountBalance(inputAmount());
			// 해당 계좌에 입금처리
			dao.updateAccount(account);
		}
	}

	// 출금
	public void withdraw() {
		// 조회할 계좌정보 입력
		// 계좌정보 정확한지 확인
		Account account = checkAccountInfo(inputAccountInfo());

		if (account != null) {
			// 해당계좌의 잔액이 존재하는지 확인
			if (account.getAccountBalance() > 0) {
				// 출금을 요청한 금액이 1원이상인지 확인 -> inputAmount()
				// 출금을 요청한 금액이 잔액보다 작은지 확인 -> checkAmount()
				long amount = checkAmount(account.getAccountBalance(), inputAmount());
				// 해당 계좌에서 출금처리
				account.setAccountBalance(-amount);
				dao.updateAccount(account);

			} else {
				System.out.println("잔액이 존재하지 않습니다.");
			}
		}
	}

	// 계좌이체
	public void transfer() {
		// 조회할 계좌정보 입력
		// 계좌정보 정확한지 확인
		Account account = checkAccountInfo(inputAccountInfo());
		if (account != null) {
			// 출금할 계좌의 잔액이 존재하는지 확인
			if (account.getAccountBalance() > 0) {
				// 상대방 계좌정보 입력받고 정확한 정보인지 확인
				Account selectedAccount = checkSelectedAccount();
				if (selectedAccount != null) {
					// 이체할 금액이 출금할 계좌의 잔액보다 작은지 확인
					long amount = checkAmount(account.getAccountBalance(), inputAmount());
					// 출금할 계좌에서 해당 금액을 출금처리
					account.setAccountBalance(-amount);
					dao.updateAccount(account);

					// 상대방 계좌에는 해당 금액을 입금처리
					selectedAccount.setAccountBalance(amount);
					dao.updateAccount(selectedAccount);
				}
			} else {
				System.out.println("잔액이 존재하지 않습니다.");
			}
		}

	}

	// 종료
	public void end() {
		System.out.println("프로그램 종료");
	}
	
	//계좌정보 전체 입력
	public Account inputAccountFull() {
		Account account = new Account();
		System.out.print("예금주>");
		account.setAccountOwner(scanner.next());
		System.out.print("비밀번호>");
		account.setAccountPassword(scanner.next());
		System.out.print("예금액>");
		account.setAccountBalance(checkBalance(scanner.nextLong()));
		return account;
	}
	
	//계좌번호와 비밀번호 입력
	public Account inputAccountInfo() {
		Account account = new Account();
		System.out.print("계좌번호>");
		account.setAccountNo(scanner.nextLong());
		System.out.print("비밀번호>");
		account.setAccountPassword(scanner.next());
		return account;
	}
	
	//금액을 입력
	public long inputAmount() {
		System.out.println("금액을 입력해주세요.>");
		return checkBalance(scanner.nextLong());
	}
	
	//계좌번호와 비밀번호 정확한지 확인하고 반환하는 메서드
	public Account checkAccountInfo(Account account) {
		Account selectedAccount = dao.selectAccountInfo(account.getAccountNo());
		if(selectedAccount == null) {
			System.out.println("해당 계좌번호가 존재하지 않습니다.");
			return null;
		}else if(selectedAccount.getAccountPassword().equals(account.getAccountPassword())) {
			return selectedAccount;
		}else {
			System.out.println("비밀번호가 일치하지 않습니다.");
			return null;
		}
	}
	
	//입력받은 금액이 1이상인지 확인하는 메서드
	public long checkBalance(long amount) {
		if(amount < 1) {
			System.out.println("금액이 1원보다 작습니다.\n다시 입력해주세요.>");
			amount = scanner.nextLong();
		}
		return amount;
	}
	//계좌의 잔액이 요청한 금액보다 큰지 확인하는 메서드
	public long checkAmount(long balance, long amount) {
		if(balance < amount) {
			System.out.println("잔액보다 요청한 금액이 큽니다.\n다시 입력해주세요,>");
			amount = scanner.nextLong();
		}
		return amount;
	}
	
	//상대방 계좌가 존재하는지 확인하는 메서드
	public Account checkSelectedAccount() {
		System.out.println("입금할 계좌번호>");
		Account selectedAccount = dao.selectAccountInfo(scanner.nextLong());
		if(selectedAccount == null) {
			System.out.println("해당 계좌번호가 존재하지 않습니다.");
			return null;
		}else {
			return selectedAccount;
		}
	}
}
