package com.yedam.java.dataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DepartmentDao {
	// db 연결정보
	private String jdbc_driver = "org.sqligte.JDBC";
	private String jdbc_url = "jdbc:sqlite:/c:/DEV/workspace/yedamDataBase";
	
	
	
	
	//각 메서드에서 공통적으로 사용하는 필드
	Connection conn =null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	
	//싱글톤    다른것들이 접근 못하게
	
	private static DepartmentDao instance = new DepartmentDao(); 
	private DepartmentDao() {}     // -->> 생성자를 프라이빗
	public static DepartmentDao getInstance() {
		return instance;
	}
	
	
	
	//메서드
	
	//jdbc driver 로딩
	//db 연결
	
	// --> connect() 메서드
	public void connect() {
		try {
			Class.forName(jdbc_driver);	//JDBC Driver 로딩
		
		
		
		conn = DriverManager.getConnection(jdbc_url);
			
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
			
		}
	}
	//자원 해제 -> disconnect() 메서드
	
	//prearedstatment 객체 생성
	//sql 실행
	//결과값 출력 or 연산
	// --> CRUD 메서드
	
	
	//자원 해제  -->> disconnect() 메서드
	
	
	
	
	
	
	
	
	
	
	
	
	
}
