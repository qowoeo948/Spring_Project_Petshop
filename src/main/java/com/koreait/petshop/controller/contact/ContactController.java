package com.koreait.petshop.controller.contact;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {
	@RequestMapping(value="/shop/contact",method = RequestMethod.GET)
	public ModelAndView adminMain(HttpServletRequest request) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/contact");	
		
		return mav;

}

}
