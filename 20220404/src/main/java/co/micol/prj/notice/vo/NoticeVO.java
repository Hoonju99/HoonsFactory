package co.micol.prj.notice.vo;

import lombok.Data;

@Data
public class NoticeVO {
	private int id;
	private String title;
	private String content;
	private Data wdate; 
	private int hit;
}
