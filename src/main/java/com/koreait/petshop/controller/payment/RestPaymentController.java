package com.koreait.petshop.controller.payment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.petshop.exception.CartException;
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
	
	//?¥ë°”êµ¬?‹ˆ?— ?ƒ?’ˆ ?‹´ê¸? ?š”ì²? 
	@RequestMapping(value="/cart/regist", method=RequestMethod.POST)
	@ResponseBody
	public MessageData registCart(Cart cart, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		
		logger.debug("product_id "+cart.getProduct_id());
		logger.debug("quantity "+cart.getQuantity());
		cart.setMember_id(member.getMember_id());
		paymentService.insert(cart);
		
		//MessageConverter ?— ?˜?•´ VO?Š” JSON?˜•?ƒœë¡? ?‘?‹µ?˜?–´ì§? ?ˆ˜ ?ˆ?‹¤!!
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("?¥ë°”êµ¬?‹ˆ?— ?ƒ?’ˆ?´ ?‹´ê²¼ìŠµ?‹ˆ?‹¤");
		messageData.setUrl("/shop/cart/list");
		
		return messageData;
	}
	
	
	//?¥ë°”êµ¬?‹ˆ?? ê´?? ¨?œ ?˜ˆ?™¸ì²˜ë¦¬ ?•¸?“¤?Ÿ¬
	@ExceptionHandler(CartException.class)
	@ResponseBody
	public MessageData handleException(CartException e) {
		logger.debug("?•¸?“¤?Ÿ¬ ?™?‘?•¨ ", e.getMessage());
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);
		messageData.setMsg(e.getMessage());
		
		return messageData;
	}
	

}











