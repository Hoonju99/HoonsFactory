package com.yedam.java.Kiosk;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.java.common.DAO;

public class KioskDAOImpl extends DAO implements KioskDAO {

	private static KioskDAO instance = new KioskDAOImpl();

	private KioskDAOImpl() {
	}

	public static KioskDAO getinstance() {
		return instance;
	}

	@Override
	public List<Kiosk> selectAll() {
		List<Kiosk> list = new ArrayList<>();
		try {
			connect();
			String select = "SELECT * FROM kiosk ORDER BY id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Kiosk kio = new Kiosk();
				kio.setId(rs.getInt("id"));
				kio.setPw(rs.getInt("pw"));
				kio.setMenuNo(rs.getInt("menu_no"));
				kio.setMenuName(rs.getString("menu_name"));
				kio.setPrice(rs.getInt("price"));
				;

				list.add(kio);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}

	@Override
	public void insert(Kiosk kiosk) {

		try {
			connect();
			String insert = "INSERT INTO kiosk VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			pstmt.setInt(1, kiosk.getId());
			pstmt.setInt(2, kiosk.getPw());
			pstmt.setInt(3, kiosk.getMenuNo());
			pstmt.setString(4, kiosk.getMenuName());
			pstmt.setInt(5, kiosk.getPrice());

			int result = pstmt.executeUpdate();

			System.out.println(result + "건이 등록되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void update(Kiosk kiosk) {

		try {
			connect();
			String update = "UPDATE kiosk SET price = ?, menu_name = ? WHERE menu_no = ?";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(3, kiosk.getMenuNo());
			pstmt.setInt(1, kiosk.getPrice());
			pstmt.setString(2, kiosk.getMenuName());

			int result = pstmt.executeUpdate();

			System.out.println(result + "건이 수정되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

	@Override
	public void delete(int menu_no) {
		try {
			connect();
			String delete = "DELETE FROM kiosk WHERE menu_no = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1, menu_no);

			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}

}
