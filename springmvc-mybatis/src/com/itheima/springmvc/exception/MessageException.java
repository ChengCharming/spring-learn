package com.itheima.springmvc.exception;

public class MessageException extends Exception {
	private String msg;
	public MessageException(String msg) {
		this.msg=msg;
	}
	public String getMsg() {
		return msg;
	}
	
}
