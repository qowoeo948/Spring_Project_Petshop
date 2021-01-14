package com.koreait.petshop.model.qna.service;

import java.util.List;

import com.koreait.petshop.model.domain.Comments;

public interface CommentsService {
	public List selectAll(int board_id);
	public void insert(Comments comments);
	public void delete(int comments_id);

}
