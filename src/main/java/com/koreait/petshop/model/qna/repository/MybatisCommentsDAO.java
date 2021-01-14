package com.koreait.petshop.model.qna.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop.model.domain.Comments;

@Repository
public class MybatisCommentsDAO implements CommentsDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll(int board_id) {
		
		return sqlSessionTemplate.selectList("Comments.selectAll",board_id);
	}

	@Override
	public void insert(Comments comments) {
		sqlSessionTemplate.insert("Comments.insert",comments);
		
	}

	@Override
	public void delete(int comments_id) {
		sqlSessionTemplate.delete("Comments.delete",comments_id);
	}

}
