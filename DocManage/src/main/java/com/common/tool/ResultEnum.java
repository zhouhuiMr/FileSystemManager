package com.common.tool;

public enum ResultEnum {
	SUCCESS("0000", "成功"),

	ERROR("0000", "错误");

	private String code = "";
	private String message = "";

	private ResultEnum(String code, String message) {
		this.code = code;
		this.message = message;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
