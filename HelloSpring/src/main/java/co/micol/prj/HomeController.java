package co.micol.prj;

import java.util.Locale;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
	// ioc = spring 컨테이너
	@RequestMapping("/") // get 방식만 받음
	public String home(Locale locale, Model model) {      // GetMapping  PostMapping --> 이렇게씀
		
		return "home/home";
	}
	
	@RequestMapping("/home.do") // get post 방식 다 받아짐
	public String home() {
		return "home/home";      //메소드 오버로딩
	}
	
}
