package com.koreait.petshop.aop;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.exception.CartException;
import com.koreait.petshop.exception.LoginAsyncRequiredException;
import com.koreait.petshop.exception.LoginRequiredException;
import com.koreait.petshop.model.common.MessageData;


/*��� ��Ʈ�ѷ����� ������ ����ó�� �ڵ鷯�� �ۼ��ϸ� �ڵ� �ߺ��� �߻��ϹǷ�, 
 *��Ʈ�ѷ����� �߻��ϴ� ��� ���ܸ� �����ϴ� ��ü�� �����Ͽ�, ���뿹��ó���� 
 *�ۼ�����!!
 * */
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(LoginRequiredException.class)
	public ModelAndView handleException(LoginRequiredException e) {
		ModelAndView mav = new ModelAndView();
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);
		messageData.setMsg(e.getMessage());
		mav.addObject("messageData", messageData);
		mav.setViewName("shop/error/message");
		
		return mav;
	}
	
	@ExceptionHandler(LoginAsyncRequiredException.class)
	@ResponseBody
	public ModelAndView handleException(LoginAsyncRequiredException e) {
		ModelAndView mav = new ModelAndView();
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);
		messageData.setMsg(e.getMessage());
		mav.addObject("messageData", messageData);
		mav.setViewName("shop/error/message");
		
		return mav;
	}
	
}