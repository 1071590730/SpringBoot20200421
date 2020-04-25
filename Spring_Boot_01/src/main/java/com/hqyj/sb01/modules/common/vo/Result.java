package com.hqyj.sb01.modules.common.vo;

public class Result<T> {

	//状态值
	private int status;
	//消息
	private String message;
	//对象
	private T object;
	
	public Result() {
	}

	public Result(int status, String message) {
		this.status = status;
		this.message = message;
	}

	public Result(int status, String message, T object) {
		this.status = status;
		this.message = message;
		this.object = object;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getObject() {
		return object;
	}

	public void setObject(T object) {
		this.object = object;
	}

	public enum ResultEnum {
		SUCCESS(200), FAILD(500);
		
		public int status;

		private ResultEnum(int status) {
			this.status = status;
		}
	}

}
