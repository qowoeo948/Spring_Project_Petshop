package com.koreait.petshop.controller.main;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	@RequestMapping(value="/petshop",method = RequestMethod.GET)
	public ModelAndView main() {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");	
		
		return mav;
	}
}
