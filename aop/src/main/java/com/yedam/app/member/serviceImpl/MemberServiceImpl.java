package com.yedam.app.member.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.app.member.service.MemberService;
import com.yedam.app.member.service.MemberVO;

@Service("memberService")
public class MemberServiceImpl implements MemberService, UserDetailsService {

	@Autowired
	MemberMapper map;

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		return map.memberselect(vo);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = new MemberVO();
		vo.setId(username);
		MemberVO result = map.memberselect(vo);
		if (result == null) {
			throw new UsernameNotFoundException("no user");
		}
		return result;
	}

	@Override
	@Transactional
	public int insertMember(MemberVO vo) {
		map.insertMember(vo);//commit
		map.insertMember(vo);//error
		return 1;
	}

}
