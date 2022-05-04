package co.micol.dbtest.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.coyote.Request;

import co.micol.dbtest.member.vo.MemberVO;

public class MainPage implements DbCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 시작페이지 돌려주기
		MemberVO vo = new MemberVO();
		
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		
		request.setAttribute("member", vo);
		
		
		
		
		
		
		return "main/main.tiles";
	}

}
