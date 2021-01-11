package com.koreait.petshop.controller.member;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.member.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	//회원가입 폼 요청
	@RequestMapping(value="/petshop/register")
	public ModelAndView getRegister() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("shop/member/register");
		
		return mav;
	}
	
	@RequestMapping(value = "/user/idCheck", method = RequestMethod.GET)
	@ResponseBody
	public int idCheck(@RequestParam("userId") String user_id) {

		return memberService.userIdCheck(user_id);
	}
	
	//회원가입 요청 처리 
	@RequestMapping(value="/shop/member/regist", method=RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String regist(Member member) {
		logger.debug("아이디 "+member.getUser_id());
		logger.debug("이름 "+member.getName());
		logger.debug("이름 "+member.getPhone());
		logger.debug("비번 "+member.getPassword());
		logger.debug("이메일id "+member.getEmail_id());
		logger.debug("이메일server "+member.getEmail_server());
		logger.debug("우편번호 "+member.getZipcode());
		logger.debug("주소 "+member.getAddr());
		
		memberService.regist(member);
		
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"result\":1, ");
		sb.append(" \"msg\":\"회원가입 성공\"");
		sb.append("}");
		
		return sb.toString();
	} 
}
