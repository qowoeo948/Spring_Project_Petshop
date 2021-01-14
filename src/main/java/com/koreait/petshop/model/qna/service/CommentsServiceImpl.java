package com.koreait.petshop.model.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop.model.domain.Comments;
import com.koreait.petshop.model.qna.repository.CommentsDAO;

@Service
public class CommentsServiceImpl implements CommentsService{

	@Autowired
	private CommentsDAO commentsDAO;
	
	@Override
	public List selectAll(int board_id) {
		return commentsDAO.selectAll(board_id);
	}

	@Override
	public void insert(Comments comments) {
		commentsDAO.insert(comments);
	}

	@Override
	public void delete(int comments_id) {
		commentsDAO.delete(comments_id);
	}

}
