package com.koreait.petshop.model.member.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MybatisMemberTypeDAO implements MemberTypeDAO{
   @Autowired
   private SqlSessionTemplate sqlSessionTemplate;

   @Override
   public List selectAll() {
      return sqlSessionTemplate.selectList("MemberType.selectAll");
   }

}