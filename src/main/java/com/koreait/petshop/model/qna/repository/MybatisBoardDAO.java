package com.koreait.petshop.model.qna.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.koreait.petshop.model.domain.Board;

@Repository
public class MybatisBoardDAO implements BoardDAO{

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List selectAll() {
		return sqlSessionTemplate.selectList("Board.selectAll");
	}

	@Override
	public Board select(int board_id) {
		return sqlSessionTemplate.selectOne("Board.select",board_id);
	}

	@Override
	public void insert(Board board) {
		sqlSessionTemplate.insert("Board.insert",board);
	}

	@Override
	public void update(Board board) {
		sqlSessionTemplate.update("Board.update",board);
	}
	@Override
	public void updateHit(int board_id) {
		sqlSessionTemplate.update("Board.updateHit",board_id);
	}

	@Override
	public void delete(int board_id) {
		sqlSessionTemplate.delete("Board.delete",board_id);
	}


}
