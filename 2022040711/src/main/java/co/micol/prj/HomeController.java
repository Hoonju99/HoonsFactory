package co.micol.prj;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(Model model) {
		
		return "home/home";
	}

	@RequestMapping("/home.do")
	public ModelAndView home(ModelAndView mv) {
		int a = 0;
		mv.addObject("message", "나의 페이지에 온것을 환영한다.");
		if( a ==1 )
		mv.setViewName("home/home");
		else
			mv.setViewName("home/home2");
		return mv;
	}
}
