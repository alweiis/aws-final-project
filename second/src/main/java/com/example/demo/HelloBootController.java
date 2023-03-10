package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloBootController {
	@Autowired
	HelloDTO dto;
	
	@GetMapping("/helloboot")
	public ModelAndView helloBoot() {
		ModelAndView mv = new ModelAndView();
		HelloDTO dto = new HelloDTO();
		dto.setModel("부트 실행 결과입니다.");
		mv.addObject("dto", dto);
		mv.setViewName("helloboot");
		return mv;
	}
	
	@ResponseBody
	@GetMapping("/hellobootajax")
	public String helloajax() {
		return "{\"result\": \"부트에서 ajax 호출결과 응답 \"}";	
	}
	
}
