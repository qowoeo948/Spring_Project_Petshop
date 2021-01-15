package com.koreait.petshop.controller.main;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.model.product.service.ProductService;
import com.koreait.petshop.model.product.service.ProductServiceImpl;

@Controller
public class MainController {
   @Autowired 
   private ProductService productService;

   @RequestMapping(value="/",method = RequestMethod.GET)
   public ModelAndView main(HttpServletRequest request) {
      ModelAndView mav = new ModelAndView();
      List hitList = productService.seletByHit();
      mav.addObject("hitList",hitList);
      mav.setViewName("index");   
      
      return mav;
   }
   
   
}