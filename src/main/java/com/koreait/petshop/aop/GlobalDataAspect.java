package com.koreait.petshop.aop;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.model.domain.Admin;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.member.service.MemberTypeService;
import com.koreait.petshop.model.payment.service.PaymentService;
import com.koreait.petshop.model.product.service.TopCategoryService;

/*
 * ���θ� �̿�� ���������� ����� ī�װ� �޴� ���
 * */
public class GlobalDataAspect {
   @Autowired
   private TopCategoryService topCategoryService;
   
   @Autowired
   private MemberTypeService memberTypeService;
   
   @Autowired
   private PaymentService paymentService;
   
   public Object getGlobalData(ProceedingJoinPoint joinPoint) throws Throwable{
      Object result=null;
      HttpServletRequest request=null;
      
      //�Ű������κ��� ��û ��ü ����!!
      for(Object arg : joinPoint.getArgs()) {
         if(arg instanceof HttpServletRequest) {
            request = (HttpServletRequest)arg;
         }
      }
      
      String uri = request.getRequestURI(); //Ŭ���̾�Ʈ�� ��û URI ��Ʈ�� ����
      HttpSession session = request.getSession();
      
      //topList�� �����ؾ� �ϴ� ���� �׷��� ���� ��츦 ����� ó��
      if(   uri.equals("/shop/member/login") || 
    	         uri.equals("/shop/member/regist") ||
    	         uri.equals("/shop/admin/regist") ||
    	         uri.equals("/user/idCheck") ||
    	         uri.equals("/admin/idCheck") ||
    	         uri.equals("/admin/product/excel/registform") ||
    	         uri.equals("/admin/product/sublist") ||
    	         uri.equals("/shop/qna/comments/list")||
    	         uri.equals("/shop/qna/comment/regist")
    	      ) {
         result=joinPoint.proceed(); //���� ȣ���Ϸ� �ߴ� �޼��� ȣ��!! go ahead
      }else {//�ʿ��� ���
         //topList ��������
         List topList = topCategoryService.selectAll();
         List memberTypeList = memberTypeService.selectAll();
         List cartList = new ArrayList();
         Member member = (Member)session.getAttribute("member");
         Admin admin = (Admin)session.getAttribute("admin");
         if(session != null && member != null) {
        	 cartList = paymentService.selectCartList(member.getMember_id());
         }
         Object returnObj = joinPoint.proceed();//���� ȣ���Ϸ� �ߴ� �޼���ȣ��
         ModelAndView mav = null;
         if( returnObj instanceof ModelAndView) {
            mav =(ModelAndView)returnObj;
            mav.addObject("topList",topList);
            mav.addObject("cartList",cartList);
            mav.addObject("memberType",memberTypeList);
            mav.addObject("member",member);
            mav.addObject("admin",admin);
            result=mav;
         }
      }
      return result;
   }
}