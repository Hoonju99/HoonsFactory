package com.yedam.java.common;



	
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;

	public class DAO {
		// Sqlite 연결정보
		private String jdbc_driver = "org.sqlite.JDBC";
		private String jdbc_url = "jdbc:sqlite:/c:/DEV/workspace/YedamDataBase.db";

		// 각 메서드에서 공통적으로 사용하는 필드
		protected Connection conn = null;
		protected PreparedStatement pstmt = null;
		protected ResultSet rs = null;

		// JDBC Driver 로딩
		// DB 서버 접속
		// -> connect() 메서드
		public void connect() {
			try {
				Class.forName(jdbc_driver);

				conn = DriverManager.getConnection(jdbc_url);
			} catch (ClassNotFoundException e) {
				System.out.println("JDBC Driver 로딩 실패");
			} catch (SQLException e) {
				System.out.println("DB 접속 실패");
			}

		}

		// 자원해제 -> disconnect() 메서드
		public void disconnect() {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				System.out.println("정상적으로 자원이 해제되지 않았습니다.");
			}
		}
	}

	
	

