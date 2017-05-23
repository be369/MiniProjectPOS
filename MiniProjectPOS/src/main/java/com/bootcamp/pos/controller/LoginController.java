package com.bootcamp.pos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@RequestMapping(value="/login.html", method=RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value="error", required=false) String error,
			@RequestParam(value="logout",required=false) String logout){
		ModelAndView model = new ModelAndView();
		if(error != null){
			model.addObject("erroe", "Invalid username and password");
		}
		if (logout != null) {
			model.addObject("msg", "You are have logged out successfully");
		}
		return model;
	}
}
