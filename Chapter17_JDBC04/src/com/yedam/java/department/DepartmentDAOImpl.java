package com.yedam.java.department;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class DepartmentDAOImpl extends DAO implements DepartmentDAO {
//싱글톤
	private static DepartmentDAO instance = new DepartmentDAOImpl()	;
	private DepartmentDAOImpl() {}
	public static DepartmentDAO getInstance() {
		return instance;
	}
	
	@Override
	public List<Department> selectAll() {
	List<Department> list = new ArrayList<Department>();
		try {
			connect();
			String seclect = "SELECT * FROM departments ORDER BY department_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Department dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("department_name"));
				dept.setManagerId(rs.getString("manager_id"));
				dept.setLocationId(rs.getInt("location_id"));
						
				
				list.add(dept);
			}
		} catch(SQLException e ) {
			e.printStackTrace();
		}finally {
		
			
		}
		return list;
	}

	@Override
	public Department selectOne(int departmedntId) {
		Department dept = null;
		try {
			connect();
			String  select = "SELECT * FROM department WHERE department_id = ?";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, departmedntId);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				dept = new Department();
				dept.setDepartmentId(rs.getInt("department_id"));
				dept.setDepartmentName(rs.getString("departmednt_name"));
				dept.setManagerId(rs.getString("manager_id"));
				dept.setLocationId((rs.getInt("location_id"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return null;
		
	}

	@Override
	public void insert(Department dept) {
		try {
			connect();
			String insert = "INSERT INTO departments VALUES(?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, dept.getDepartmentId());
			pstmt.setString(2, dept.getDepartmentName());
			pstmt.setString(3, dept.getDepartmentName());
			pstmt.setInt(4, dept.getLocationId());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 등록되었습니다.");
			
		} catch(SQLException e ) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
	}

	@Override
	public void update(Department dept) {

		try {
			connect();
			String update = "UPDATE departments SET department_name =  WHERE department_id = ? ";
			pstmt = conn.prepareStatement(update);
			pstmt.setString(1, dept.getDepartmentName());
			pstmt.setInt(2, dept.getDepartmentId());
			
			int result = pstmt.executeUpdate();
			
			System.out.println(result + "건이 수정되었습니다.");
		}
		catch(SQLException e) {
		e.printStackTrace();	
		} finally {
			disconnect();
		}
		
	}

	@Override
	public void delete(int departmentId) {

		try {
			connect();
			String delete = "DELETE FROM departments WHERE department_0d = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, departmentId);
			
			int result = pstmt.executeUpdate();
			System.out.println("삭제되었습니다.");
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		
		
		
	}

}
