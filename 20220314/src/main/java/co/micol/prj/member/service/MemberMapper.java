package co.micol.prj.member.service;

import java.util.List;

public interface MemberMapper {
	List<MemberVO> selectMemberList(); // 전체 리스트
	MemberVO selectMember(MemberVO vo); // 단일 리스트 또는 로그인 처리
	int insertMember(MemberVO vo); // 등록
	int updateMember(MemberVO vo); // 수정
	int deleteMember(MemberVO vo); // 삭제

	boolean isIdCheck(String str); // 아이디 중복체크
}
