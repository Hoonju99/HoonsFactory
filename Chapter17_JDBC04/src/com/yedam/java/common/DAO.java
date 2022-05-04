package com.yedam.java.common;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	//DB 연결 정보
	private String jdbc_driver = "org.sqlite.JDBC";
	private String jdbc_url = "jdbc:sqlite:/c:\\DEV\\workspace/YedamDatabase.db";
	
	//각 메서드에서 공통으로 사용하는 필드
	protected Connection conn = null;
	protected PreparedStatement pstmt = null;
	protected ResultSet rs = null;
	
	
	
	
	
	//connect() 메서드
	public void connect() {
		//JDBC Driver 로딩
		try {
			//JDBC Driver 로딩
			Class.forName(jdbc_driver);
			
			//DB 서버 연결
			
			conn = DriverManager.getConnection(jdbc_url);
		} catch (ClassNotFoundException e) {
			System.out.println("JDBC Driver 로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}
		
		
		//DB 서버 연결
	}
	
	//disconnect() 메서드
	public void disconnect() {
		try {
			if(rs != null)rs.close();
			if(pstmt != null)pstmt.close();
			if(conn != null)conn.close();
			
		}catch(SQLException e) {
			System.out.println("정상적으로 자원이 햊되지 않았습니다.");
		}
	}
	// DAO 클래스 DB와 접속 연결해제 
	
}
