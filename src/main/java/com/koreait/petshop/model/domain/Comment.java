package com.koreait.petshop.model.domain;

import lombok.Data;

@Data
public class Comment {
	private int comment_id;
	private int board_id;
	private String msg;
	private String author;
	private String cdate;
	
	
}
