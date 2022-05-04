package com.yedam.java.Kiosk;

import java.util.List;



public interface KioskDAO {
	
		//전체조회
		public List<Kiosk> selectAll();
		
		//등록
		public void insert(Kiosk kiosk);
		
		//수정
		public void update(Kiosk kiosk);
		
		//삭제
		public void delete(int menu_no);
	
		//조회
		
	
}
