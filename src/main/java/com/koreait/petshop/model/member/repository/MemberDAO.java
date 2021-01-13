package com.koreait.petshop.model.member.repository;

import java.util.List;

import com.koreait.petshop.model.domain.Member;

public interface MemberDAO {
   public List selectAll();//모든 회원가져오기
   public Member select(Member member); //회원1명 가져오기
   public void insert(Member member);//회원등록
   public void update(Member member); //회원정보 수정
   public void delete(Member member); //회원정보 삭제 
   public int checkOverId(String user_id); //아이디 중복 체크
}