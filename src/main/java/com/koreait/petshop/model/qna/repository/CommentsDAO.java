package com.koreait.petshop.model.qna.repository;

import java.util.List;

import com.koreait.petshop.model.domain.Comments;

public interface CommentsDAO {
	public List selectAll(int board_id);
	public void insert(Comments comments);
	public void delete(int comment_id);

}
