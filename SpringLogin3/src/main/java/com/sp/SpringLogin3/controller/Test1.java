package com.sp.SpringLogin3.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Test1 {
	String message = "testMsg";

	@RequestMapping("/test1")
	public ModelAndView showMessage(
			@RequestParam(value = "name", required = false, defaultValue = "defaultName") String name) {
		System.out.println("test1.java");

		ModelAndView mv = new ModelAndView("helloworld.j");
		mv.addObject("message", message);
		mv.addObject("name", name);
		return mv;
	}
}
