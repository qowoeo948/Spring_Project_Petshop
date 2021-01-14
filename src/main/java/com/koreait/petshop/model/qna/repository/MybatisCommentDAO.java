package com.koreait.petshop.model.qna.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.petshop.model.domain.Comments;

@Repository
public class MybatisCommentDAO implements CommentDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		
		return sqlSessionTemplate.selectList("Comment.selectAll");
	}

	@Override
	public void insert(Comments comment) {
		sqlSessionTemplate.insert("Comment.insert",comment);
		
	}

	@Override
	public void delete(int comment_id) {
		sqlSessionTemplate.delete("Comment.delete",comment_id);
	}

}
