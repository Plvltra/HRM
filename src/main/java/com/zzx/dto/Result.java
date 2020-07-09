package com.zzx.dto;

public class Result<T> {
	
	private boolean success;
	
	// 成功返回数据
	private T data;
	
	// 失败信息
	private String error;

	public Result() {
		super();
	}

	public Result(boolean success, T data) {
		super();
		this.success = success;
		this.data = data;
	}

	public Result(boolean success, String error) {
		super();
		this.success = success;
		this.error = error;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
