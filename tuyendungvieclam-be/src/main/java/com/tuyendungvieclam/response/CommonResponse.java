package com.tuyendungvieclam.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonResponse<T> {
	
	@JsonProperty("message")
	private String message;
	
	@JsonProperty("data")
	private T data;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
