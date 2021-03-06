package com.yedam.app.memo;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.yedam.app.common.DAO;


public class MemoDAOImpl extends DAO implements MemoDAO {

	private static MemoDAO instance = new MemoDAOImpl();

	private MemoDAOImpl() {
	}

	public static MemoDAO getinstance() {
		return instance;
	}
	
	@Override
	public List<Memo> selectAll() {
		List<Memo> list = new ArrayList<>();
		try {
			connect();
			String select = "SELECT * FROM Memo ORDER BY memo_id";
			pstmt = conn.prepareStatement(select);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Memo mm = new Memo();
				mm.setMemo_id(rs.getInt("memo_id"));
				mm.setMemo_title(rs.getString("memo_title"));
				mm.setMemo_writer(rs.getString("memo_writer"));
				mm.setMemo_content(rs.getString("memo_content"));
				;

				list.add(mm);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return list;
	}
	

	@Override
	public void insert(Memo memo) {
		try {
			connect();
			String insert = "INSERT INTO memo VALUES (?,?,?,?)";
			pstmt = conn.prepareStatement(insert);
			
			pstmt.setInt(1, memo.getMemo_id() );
			pstmt.setString(2, memo.getMemo_title());
			pstmt.setString(3, memo.getMemo_writer());
			pstmt.setString(4,	memo.getMemo_content());
			
			int result = pstmt.executeUpdate();
		System.out.println(result + "건이 등록되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
	}

	@Override
	public void update(Memo memo) {
		
		try {
			connect();
			String update = "UPDATE  memo  SET memo_content = ? WHERE memo_id = ? ";
			pstmt = conn.prepareStatement(update);
			pstmt.setInt(2, memo.getMemo_id());
			pstmt.setString(1, memo.getMemo_content());

			int result = pstmt.executeUpdate();

			System.out.println(result + "건이 수정되었습니다.");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

		
	}

	@Override
	public void delete(int memo_id) {
		try {
			connect();
			String delete = "DELETE FROM memo WHERE memo_id = ?";
			pstmt = conn.prepareStatement(delete);
			pstmt.setInt(1,memo_id);

			int result = pstmt.executeUpdate();
			System.out.println(result + "건이 삭제되었습니다");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}

	}
	

	@Override
	public Memo selectOne(int memo_id) {
		Memo mm = null;
		try {
			connect();
			String select = "SELECT * FROM memo WHERE memo_id = ? ";
			pstmt = conn.prepareStatement(select);
			pstmt.setInt(1, memo_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mm = new Memo();
				
				mm.setMemo_id(rs.getInt("memo_id"));
				mm.setMemo_title(rs.getString("memo_title"));
				mm.setMemo_writer(rs.getString("memo_writer"));
				mm.setMemo_content(rs.getString("memo_content"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		} finally {
			disconnect();
		}
		return mm;
	}

}
