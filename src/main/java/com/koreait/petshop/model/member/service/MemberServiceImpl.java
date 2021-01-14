package com.koreait.petshop.model.member.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop.exception.MailSendException;
import com.koreait.petshop.exception.MemberNotFoundException;
import com.koreait.petshop.exception.MemberRegistException;
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
      return memberDAO.selectAll();
   }

   //로그인
   @Override
   public Member select(Member member) throws MemberNotFoundException{
      //유저가 전송한 파라미터 비밀번호를 해시값으로 변환하여 아래의 메서드 호출
      String hash = secureManager.getSecureData(member.getPassword());
      member.setPassword(hash); //VO에 해쉬값 대입
      
      Member obj = memberDAO.select(member);
      
      return obj;
   }

   //회원가입
   @Override
   public void regist(Member member) throws MemberRegistException, MailSendException{
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

   //ID 중복체크
   @Override
   public int userIdCheck(String user_id) {

      return memberDAO.checkOverId(user_id);
   }
   
   @Override
   public void update(Member member) {
      
   }

   @Override
   public void delete(Member member) {
      
   }

}