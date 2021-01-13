package com.koreait.petshop.exception;

//MailSendException
public class MemberNotFoundException extends RuntimeException{

	public MemberNotFoundException(String msg) {
		super(msg);
	}
	
	public MemberNotFoundException(String msg,Throwable e) {
		super(msg,e);
	}
	
}
