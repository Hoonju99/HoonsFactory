package co.micol.prj.member.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService memberDao;
	
	
	@RequestMapping("/memberSelectList.do")
	public String memberSelectList(Model model) {
		model.addAttribute("memberList", memberDao.memberSelectList());
		return "member/memberSelectList";
	}
	
	@RequestMapping("/memberJoinForm.do")
	public String memberJoinForm() {
		return "member/memberJoinForm";
	}
	
	@RequestMapping("/memberJoin.do")
	public String memberJoin(MemberVO vo) {
		vo.setPassword(vo.getPassword());
		memberDao.memberInsert(vo);
		return "redirect:memberSelectList.do";
		
	}
	
	@RequestMapping("/memberSelect.do")
	public String memberSelect() {
		return "member/memberSelect";
	}
	
	@RequestMapping("/memberSearch.do")
	public String memberSearch(MemberVO vo, Model model) {
		model.addAttribute("search", memberDao.memberSelect(vo));
		return "home/home";
	}
	
	
	
	
}
