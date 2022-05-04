package co.micol.prj.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.common.DataSource;
import co.micol.prj.member.service.MemberMapper;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.service.MemberVO;
import oracle.net.nt.ConnectDescription;

public class MemberServiceImpl implements MemberService {
	
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	private MemberMapper map = sqlSession.getMapper(MemberMapper.class);
	

	@Override
	public List<MemberVO> selectMemberList() {
		// 전체 리스트
			
		
		return map.selectMemberList();
	}

	@Override
	public MemberVO selectMember(MemberVO vo) {
		// 단일 리스트 또는 로그인
		return map.selectMember(vo);
	}

	@Override
	public int insertMember(MemberVO vo) {
		// 회원 등록
		return map.insertMember(vo);
	}

	@Override
	public int updateMember(MemberVO vo) {
		// 회원 수정
		return map.updateMember(vo);
	}

	@Override
	public int deleteMember(MemberVO vo) {
		// 회원 삭제
		return map.deleteMember(vo);
	}

	@Override
	public boolean isIdCheck(String str) {
		// 중복 체크
		return map.isIdCheck(str);
	}
	
	
	
	

}
