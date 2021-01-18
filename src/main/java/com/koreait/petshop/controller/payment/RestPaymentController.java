package com.koreait.petshop.controller.payment;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.exception.CartException;
import com.koreait.petshop.exception.LoginRequiredException;
import com.koreait.petshop.model.common.MessageData;
import com.koreait.petshop.model.domain.Cart;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.payment.service.PaymentService;


@Controller
@RequestMapping(value="/async")
public class RestPaymentController {
   private static final Logger logger=LoggerFactory.getLogger(RestPaymentController.class);
   
   @Autowired
   private PaymentService paymentService;
   
   //��ٱ��Ͽ� ��ǰ ��� ��û 
   @RequestMapping(value="/shop/cart/regist", method=RequestMethod.POST, produces="text/html;charset=utf-8")
   @ResponseBody
   public MessageData registCart(Cart cart, HttpServletRequest request) {
      HttpSession session = request.getSession();
      Member member = (Member)session.getAttribute("member");
      
      if(session.getAttribute("member")==null) {
         throw new LoginRequiredException("�α����� �ʿ��� �����Դϴ�.");
      }
      
      logger.debug("product_id "+cart.getProduct_id());
      logger.debug("quantity "+cart.getQuantity());
      cart.setMember_id(member.getMember_id());
      paymentService.insert(cart);
      
      //MessageConverter �� ���� VO�� JSON���·� ����Ǿ��� �� �ִ�!!
      MessageData messageData = new MessageData();
      messageData.setResultCode(1);
      messageData.setMsg("��ٱ��Ͽ� ��ǰ�� �����ϴ�");
      messageData.setUrl("/shop/cart/list");
      
      return messageData;
   }
   
   //��ٱ��� ����
   @RequestMapping(value="/shop/cart/edit", method=RequestMethod.POST)
   public ModelAndView editCart(HttpServletRequest request, @RequestParam("cart_id") int[] cartArray, @RequestParam("quantity") int[] qArray) {
      //�Ѱܹ��� �Ķ���� ����ϱ�!!  cart_id,  quantity 
      logger.debug("cartArray length "+cartArray.length);
      
      List cartList = new ArrayList();
      for(int i=0;i<cartArray.length;i++) {
         logger.debug("cartArray cart_id = "+cartArray[i]);
         logger.debug("qArray quantity = "+qArray[i]);
         Cart cart  = new Cart();
         cart.setCart_id(cartArray[i]);
         cart.setQuantity(qArray[i]);
         cartList.add(cart);
      }
      paymentService.update(cartList);
      
      //�����Ǿ��ٴ� �޽����� ����ʹٸ�.. message.jsp�� ��������
      MessageData messageData = new MessageData();
      messageData.setResultCode(1);
      messageData.setMsg("��ٱ��ϰ� �����Ǿ����ϴ�");
      messageData.setUrl("/shop/cart/list");
      ModelAndView mav = new ModelAndView();
      mav.addObject("messageData", messageData);
      mav.setViewName("shop/error/message");
      
      return mav;
   }
   
    //��ٱ��� 1�� ����
      @RequestMapping(value="/shop/cart/delete", method=RequestMethod.GET)
      @ResponseBody
      public String editCart(HttpServletRequest request, @RequestParam(value="cart_id") int cart_id) {
         paymentService.delete(cart_id);
         
         return "/shop/cart/list";
      }

   
   
   //��ٱ��Ͽ� ���õ� ����ó�� �ڵ鷯
   @ExceptionHandler(CartException.class)
   @ResponseBody
   public MessageData handleException(CartException e) {
      logger.debug("�ڵ鷯 ������ ", e.getMessage());
      MessageData messageData = new MessageData();
      messageData.setResultCode(0);
      messageData.setMsg(e.getMessage());
      
      return messageData;
   }
   

}