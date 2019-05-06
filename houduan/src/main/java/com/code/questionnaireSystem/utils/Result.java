package com.code.questionnaireSystem.utils;

public class Result {
	private Integer code;
	private String msg;
	private Object data;

	public Result() {
	};

	public Result(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public void setResultCode(ResultCode code) {
		this.code = code.code();
		this.msg = code.message();
	}

	public static Result success() {
		Result result = new Result();
		result.setResultCode(ResultCode.SUCCESS);
		return result;
	}

	public static Result success(Object data) {
		Result result = new Result();
		result.setResultCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}

	public static Result failure(ResultCode responseCode) {
		Result result = new Result();
		result.setResultCode(responseCode);
		return result;
	}

	public static Result failure(ResultCode responseCode, Object data) {
		Result result = new Result();
		result.setResultCode(responseCode);
		result.setData(data);
		return result;
	}

	public static Result failure(ResultCode responseCode, String msg) {
		Result result = new Result();
		result.setResultCode(responseCode);
		result.setMsg(msg);
		return result;

	}

}
