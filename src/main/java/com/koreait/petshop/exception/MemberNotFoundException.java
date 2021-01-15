package com.koreait.petshop.exception;

//CRUD ?‘?—…?‹œ ë°œìƒ?˜?Š” ?˜ˆ?™¸
public class MemberNotFoundException extends RuntimeException{
	
	public MemberNotFoundException(String msg) {
		super(msg);
	}
	public MemberNotFoundException(String msg, Throwable e) {
		super(msg, e);
	}
}
