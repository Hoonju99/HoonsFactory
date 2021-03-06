package com.yedam.app.memo;

public class Memo {
	private int memo_id;
	private String memo_title;
	private String memo_writer;
	private String memo_content;
	
	public int getMemo_id() {
		return memo_id;
	}
	public void setMemo_id(int memo_id) {
		this.memo_id = memo_id;
	}
	public String getMemo_title() {
		return memo_title;
	}
	public void setMemo_title(String memo_title) {
		this.memo_title = memo_title;
	}
	public String getMemo_writer() {
		return memo_writer;
	}
	public void setMemo_writer(String memo_writer) {
		this.memo_writer = memo_writer;
	}
	public String getMemo_content() {
		return memo_content;
	}
	public void setMemo_content(String memo_content) {
		this.memo_content = memo_content;
	}
	@Override
	public String toString() {
		return "메모번호 : " + memo_id + ", 메모제목 : " + memo_title + ", 메모 작성자 : " + memo_writer + ", 메모 내용 : " + memo_content;
	}
	
	
}
