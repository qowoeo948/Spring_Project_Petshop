package com.koreait.petshop.model.qna.service;

import java.util.List;

import com.koreait.petshop.model.domain.Comment;

public interface CommentService {
	public List selectAll();
	public void insert(Comment comment);
	public void delete(int comment_id);

}
