package co.micol.prj.member.web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import co.micol.prj.member.service.MemberVO;

@Controller
public class MemberController {

	@Autowired // IoC(컨테이너)에 있는 class를 갖다주세요.
	private DataSource dataSource;

	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;

	@RequestMapping("memberSelectList.do")
	public String memberSelectList(Model model, MemberVO vo) {
		List<MemberVO> list = new ArrayList<MemberVO>();
		try {
			conn = dataSource.getConnection();
			if (conn != null) {
				psmt = conn.prepareStatement("select * from member");
				rs = psmt.executeQuery();
				while (rs.next()) {
					vo = new MemberVO();
					vo.setId(rs.getString("id"));
					vo.setPassword(rs.getString("password"));
					vo.setName(rs.getString("name"));
					list.add(vo);
				}
				model.addAttribute("members", list);
				model.addAttribute("message", "멤버리스트 입니다.");
			} else {
				System.out.println("DB 연결 실패!!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "member/memberSelectList";
	}
}
