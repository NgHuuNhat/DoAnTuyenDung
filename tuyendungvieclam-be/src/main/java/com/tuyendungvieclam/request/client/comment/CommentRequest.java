package com.tuyendungvieclam.request.client.comment;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommentRequest {
	
	@JsonProperty("new_id")
	private String newId;
	
	@JsonProperty("content")
	private String content;

	public String getNewId() {
		return newId;
	}

	public void setNewId(String newId) {
		this.newId = newId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
}
