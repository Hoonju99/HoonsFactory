package com.yedam.myserver.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.myserver.emp.mapper.EmployeeMapper;
import com.yedam.myserver.emp.vo.Employee;

@Controller
public class EmpPageController {
	
	@Autowired EmployeeMapper mapper;
	
	//사번조회페이지 이동
	@RequestMapping("/emp1")
	public String emp1(){
		return "emp1";
	}
	
	//해당 사번의 사원정보를 조회하고 조회페이지 이동
	@PostMapping("/findById")
	public String findById(Employee vo, Model model) {
		//1파라미터 받고
	
		//2단건조회
		List<Employee> list = mapper.findEmployees(vo);
		//3조회결과를 request 저장 == model
		model.addAttribute("emp", list);
		
		//4.뷰페이지로 이동
		return "emp2";   //forward(페이지이동 request)
	}
	
	@PostMapping("/ajax/findById")
	@ResponseBody   //자바객체 -> json 스트링 "[{}]"
	public List<Employee> ajaxfindById(Employee vo) {
		List<Employee> list = mapper.findEmployees(vo);
		return list;
	}
}




