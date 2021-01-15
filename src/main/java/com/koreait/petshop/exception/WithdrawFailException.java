package com.koreait.petshop.exception;

public class WithdrawFailException extends RuntimeException{
	
	public WithdrawFailException(String msg) {
		super(msg);
	}
	public WithdrawFailException(String msg, Throwable e) {
		super(msg, e);
	}

}
