package com.koreait.petshop.controller.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

   @RequestMapping(value="/",method = RequestMethod.GET)
   public ModelAndView main(HttpServletRequest request) {
      
      ModelAndView mav = new ModelAndView();
      mav.setViewName("index");   
      
      return mav;
   }
   
   @RequestMapping(value="/shop/test",method=RequestMethod.GET)
   public ModelAndView test(HttpServletRequest request) {
      ModelAndView mav = new ModelAndView();
      mav.setViewName("shop/test");   
      return mav;
   }
}