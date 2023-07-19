package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	@RequestMapping("/helloboot")
	public ModelAndView helloboot() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("model", "스프링부트를 시작합니다.");
		mv.setViewName("hello");
		return mv;
	}
	
	@RequestMapping("/helloajax")
	public @ResponseBody String helloajax() {
		return "{\"model\":\"스프링부트(ajax)를 시작합니다.\"}";
	}
}

// - 프로젝트 파일 우클릭 -> spring -> add starters : 
// 스프링부트는 자바 객체를 json으로 변환하는 라이브러리가 자동으로 포함되어 있다.
