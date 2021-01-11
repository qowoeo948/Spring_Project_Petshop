package com.koreait.petshop.model.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop.exception.MailSendException;
import com.koreait.petshop.model.common.MailSender;
import com.koreait.petshop.model.common.SecureManager;
import com.koreait.petshop.model.domain.Member;
import com.koreait.petshop.model.member.repository.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Autowired
	private MemberDAO memberDAO;
	
	//메일발송 객체
	@Autowired
	private MailSender mailSender;
	
	//암호화 객체 
	@Autowired
	private SecureManager secureManager;

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Member select(Member member) {
		return null;
	}

	@Override
	public void regist(Member member) throws MailSendException{
		//암호화 처리 
		String secureData = secureManager.getSecureData(member.getPassword());
		member.setPassword(secureData); //변환시켜 다시 VO에 대입
		
		//DB에 넣기
		memberDAO.insert(member);
		
		//메일발송
		String name=member.getName();
		String addr=member.getAddr();
		String email = member.getEmail_id()+"@"+member.getEmail_server();
		
		mailSender.send(email , name+"님 [팻토피아]가입축하드려요", addr+"에 거주하세요? 감사합니당");
	}

	@Override
	public int userIdCheck(String user_id) {
		//ID 중복체크
		memberDAO = sqlSessionTemplate.getMapper(MemberDAO.class);

		return memberDAO.checkOverId(user_id);
	}
	
	@Override
	public void update(Member member) {
		
	}

	@Override
	public void delete(Member member) {
		
	}

}
