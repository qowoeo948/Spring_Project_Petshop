package com.koreait.petshop.model.qna.repository;

import java.util.List;

import com.koreait.petshop.model.domain.Comment;

public interface CommentDAO {
	public List selectAll();
	public void insert(Comment comment);
	public void delete(int comment_id);

}
