package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.common.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// Ajax로 아이디 중복체크
		MemberService memberDao = new MemberServiceImpl();
		String str = request.getParameter("str"); // ajax에서 넘어온 str 이라는 변수
		boolean b = memberDao.isIdCheck(str);
		String result;
		if(!b) {
			result = "ajax:0"; //이미 존재하는 아이디
		}else {
			result = "ajax:1"; //사용 가능한 아이디
		}
		return result;
	}

}
