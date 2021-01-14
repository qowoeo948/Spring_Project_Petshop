package com.koreait.petshop.model.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.petshop.model.domain.Comments;
import com.koreait.petshop.model.qna.repository.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentDAO commentDAO;
	
	@Override
	public List selectAll() {
		return commentDAO.selectAll();
	}

	@Override
	public void insert(Comments comment) {
		commentDAO.insert(comment);
	}

	@Override
	public void delete(int comment_id) {
		commentDAO.delete(comment_id);
	}

}
