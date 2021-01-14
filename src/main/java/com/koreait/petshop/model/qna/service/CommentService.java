package com.koreait.petshop.model.qna.service;

import java.util.List;

import com.koreait.petshop.model.domain.Comments;

public interface CommentService {
	public List selectAll();
	public void insert(Comments comment);
	public void delete(int comment_id);

}
