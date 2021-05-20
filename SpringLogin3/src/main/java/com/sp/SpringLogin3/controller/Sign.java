package com.sp.SpringLogin3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.MvcNamespaceHandler;

import com.sp.SpringLogin3.entities.User;
import com.sp.SpringLogin3.service.SignService;

@Controller
public class Sign {

	@Autowired
	private SignService signService;

	@RequestMapping("/sign") // 進sign頁
	public ModelAndView entry() {
		System.out.println("entry method");
		ModelAndView mv = new ModelAndView("sign.j");
		return mv;
	}

	@RequestMapping("/signUp") // 註冊
	public ModelAndView signUp(
			@RequestParam("sup_username") String username,
			@RequestParam("sup_password") String password,
			@RequestParam("sup_sex") String sex,
			@RequestParam("sup_email") String email) {
		System.out.println("CTL signUP method");
		System.out.println(username);

		User user = new User();
		user.setUsername(username);
		user.setPassword(password);
		user.setSex(sex);
		user.setEmail(email);

		String result=null;
		result=(signService.signUp(user))==true? "註冊成功":"註冊失敗";
		ModelAndView mv = new ModelAndView("sign.j");
		mv.addObject("message", result);
		return mv;
	}

	@RequestMapping("/signIn") // 登入
	public ModelAndView signIn() {
		ModelAndView mv = new ModelAndView("sign.j");
		return mv;
	}

	@RequestMapping("/forgot") // 忘密碼
	public ModelAndView forgot() {
		ModelAndView mv = new ModelAndView("sign.j");
		return mv;
	}
}
