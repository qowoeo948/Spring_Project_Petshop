package com.koreait.petshop.exception;

//CRUD ?‘?—…?‹œ ë°œìƒ?˜?Š” ?˜ˆ?™¸
public class ProductRegistException extends RuntimeException{
	
	public ProductRegistException(String msg) {
		super(msg);
	}
	public ProductRegistException(String msg, Throwable e) {
		super(msg, e);
	}
}
