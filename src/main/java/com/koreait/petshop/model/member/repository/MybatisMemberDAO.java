package com.koreait.petshop.model.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop.model.domain.Member;

@Repository
public class MybatisMemberDAO implements MemberDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Member select(Member member) {
		return null;
	}

	@Override
	public void insert(Member member) {
		sqlSessionTemplate.insert("Member.insert", member);
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
