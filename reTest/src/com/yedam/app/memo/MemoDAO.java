package com.yedam.app.memo;

import java.util.List;

public interface MemoDAO {
	
	public List<Memo> selectAll();
	
	public void insert(Memo memo);
	
	public void update(Memo memo);
	
	public void delete(int memo_id);
	
	public Memo selectOne(int memo_id);
}
