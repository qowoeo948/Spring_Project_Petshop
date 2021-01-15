package com.koreait.petshop.exception;

//CRUD ?‘?—…?‹œ ë°œìƒ?˜?Š” ?˜ˆ?™¸
public class MailSendException extends RuntimeException{
	
	public MailSendException(String msg) {
		super(msg);
	}
	public MailSendException(String msg, Throwable e) {
		super(msg, e);
	}
}
