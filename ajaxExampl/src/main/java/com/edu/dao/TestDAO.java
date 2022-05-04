package com.edu.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestDAO extends DAO {
	public void insertTest(String do_id, String do_content) {
		String sql = "insert into to_do_list values (to_do_seq, ?)";
		
		PreparedStatement psmt;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, do_content);
			ResultSet r = psmt.executeQuery();
			System.out.println(r + " 입력.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public List<Map<String, String>> to_do_List() {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		
		String sql = "select * from to_do_list order by 1";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("id", rs.getString("do_id"));
				map.put("content", rs.getString("do_salary"));
				
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
