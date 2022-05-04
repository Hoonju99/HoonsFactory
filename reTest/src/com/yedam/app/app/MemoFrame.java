package com.yedam.app.app;

import java.util.List;
import java.util.Scanner;

import com.yedam.app.memo.Memo;
import com.yedam.app.memo.MemoDAO;
import com.yedam.app.memo.MemoDAOImpl;



public class MemoFrame {

	private Scanner sc = new Scanner(System.in);
	private MemoDAO dao = MemoDAOImpl.getinstance();

	public void run() {
		while (true) {

			menuPrint();

			int menuNo = menuSelect();

			if (menuNo == 1) {
				insertMemo();
			} else if (menuNo == 2) {
				updateMemo();
			} else if (menuNo == 3) {
				deleteMemoId();
			} else if (menuNo == 4) {
				selectOne();
			} else if (menuNo == 5) {
				selectAll();
			} else if (menuNo == 9) {
				end();
				break;
			}
		}
	}

	public void menuPrint() {
		System.out.println();
		System.out.println("======================================================");
		System.out.println("1.등록 | 2.수정 | 3.삭제 | 4.메모조회 | 5.전체조회 | 9.종료");
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

	public void insertMemo() {
		Memo mm = inputMemoInfo();
		dao.insert(mm);
	}

	private Memo inputMemoInfo() {

		Memo mm = new Memo();
		System.out.println("메모번호>>");
		mm.setMemo_id(sc.nextInt());
		System.out.println("메모제목>>");
		mm.setMemo_title(sc.next());
		System.out.println("메모작성자>>");
		mm.setMemo_writer(sc.next());
		System.out.println("메모내용>>");
		mm.setMemo_content(sc.next());

		return mm;

	}

	
	
	public void updateMemo() {
		Memo mm = inputMemoContent();
		dao.update(mm);
	}
	
	public Memo inputMemoContent() {
		Memo mm = new Memo();
		System.out.println("메모번호>>");
		mm.setMemo_id(sc.nextInt());
		System.out.println("메모내용>>");
		mm.setMemo_content(sc.next());

		return mm;
	}
	
	public void selectAll() {
		List<Memo> list = dao.selectAll();
		for(Memo mm : list) {
			System.out.println(mm);
		}
	}
	
	public void deleteMemoId() {
		int menuNo = inputMemoId();		
		dao.delete(menuNo);
	}
	
	public int inputMemoId() {
		System.out.println("메뉴넘버>");
		int	MemoId = sc.nextInt();
		return MemoId;
	}

	public void end() {
		System.out.println("프로그램 종료");
	}
	
	public void selectOne() {
		int memoId = inputMemoId();		
		Memo mm = dao.selectOne(memoId);
		System.out.println(mm);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
