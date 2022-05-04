package com.yedam.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SlipController {
	
	@Autowired
	SlipService service;

	
	@ResponseBody
	@PostMapping("/insertSlip")
	public ResultVO insertSlip(@RequestBody List<Slip> list) {
		return service.insertSlip(list);	
	}

	
}
