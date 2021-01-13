package com.koreait.petshop.model.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop.model.member.repository.MemberTypeDAO;

@Service
public class MemberTypeServiceImpl implements MemberTypeService{
	@Autowired
	private MemberTypeDAO memberTypeDAO;

	@Override
	public List selectAll() {
		return memberTypeDAO.selectAll();
	}

}
