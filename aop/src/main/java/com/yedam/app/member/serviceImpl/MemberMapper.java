package com.yedam.app.member.serviceImpl;

import com.yedam.app.member.service.MemberVO;

public interface MemberMapper {
	MemberVO memberselect(MemberVO vo);
	int insertMember(MemberVO vo);
}
