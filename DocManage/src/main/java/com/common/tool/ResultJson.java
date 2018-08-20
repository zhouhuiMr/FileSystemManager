package com.common.tool;

public class ResultJson {
	private String code = "";
	private String message = "";
	private Object data = "";

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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public void setResultEnum(ResultEnum resultenum){
		this.code = resultenum.getCode();
		this.message = resultenum.getMessage();
	}
}
