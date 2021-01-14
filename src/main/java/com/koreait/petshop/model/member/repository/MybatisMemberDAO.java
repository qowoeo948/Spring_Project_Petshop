package com.koreait.petshop.model.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop.exception.MemberNotFoundException;
import com.koreait.petshop.exception.MemberRegistException;
import com.koreait.petshop.model.domain.Member;

@Repository
public class MybatisMemberDAO implements MemberDAO{
   @Autowired
   private SqlSessionTemplate sqlSessionTemplate;

   @Override
   public List selectAll() {
      return sqlSessionTemplate.selectList("Member.selectAll");
   }

   //로그인 검증
   @Override
   public Member select(Member member) throws MemberNotFoundException{
      Member obj = sqlSessionTemplate.selectOne("Member.select", member);
      if(obj == null) { //올바르지 않은 정보로 회원을 조회하려고 하는 것임..
         throw new MemberNotFoundException("로그인 정보가 올바르지 않습니다.");
      }
      
      return obj;
   }

   @Override
   public void insert(Member member) {
      int result = sqlSessionTemplate.insert("Member.insert", member);
      if (result == 0) {
         throw new MemberRegistException("회원가입에 실패하였습니다.");
      }
   }

   @Override
   public void update(Member member) {
      
   }

   @Override
   public void delete(Member member) {
      
   }

   @Override
   public int checkOverId(String user_id) {
      
      return sqlSessionTemplate.selectOne("Member.checkOverId", user_id);
   }

}