package com.koreait.petshop.model.qna.service;

import java.util.List;

import com.koreait.petshop.model.domain.Board;

public interface BoardService{
	public List selectAll();
	public Board select(int board_id);
	public void insert(Board board);
	public void update(Board board);
	public void updateHit(int board_id);
	public void delete(int board_id);


}
