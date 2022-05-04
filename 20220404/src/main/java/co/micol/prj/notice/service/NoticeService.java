package co.micol.prj.notice.service;

import java.util.List;

import co.micol.prj.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList();
	NoticeVo noticeSelect(NoticeVO vo);
	int noticeInsert (NoticeVO vo);
	int noticeDelete (NoticeVO vo);
	int noticeUpdate (NoticeVO vo);
}
