package com.koreait.petshop.model.qna.repository;

import java.util.List;

import com.koreait.petshop.model.domain.Comments;

public interface CommentDAO {
	public List selectAll();
	public void insert(Comments comment);
	public void delete(int comment_id);

}
