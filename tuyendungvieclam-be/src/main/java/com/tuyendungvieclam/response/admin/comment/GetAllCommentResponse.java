package com.tuyendungvieclam.response.admin.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tuyendungvieclam.dto.CommentDTO;

public class GetAllCommentResponse {

	@JsonProperty("comment_id")
	private String commentId;
	
	@JsonProperty("content")
	private String content;
	
	@JsonProperty("total_reviewed")
	private int totalReviewed;
	
	@JsonProperty("total_like")
	private int totalLike;

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTotalReviewed() {
		return totalReviewed;
	}

	public void setTotalReviewed(int totalReviewed) {
		this.totalReviewed = totalReviewed;
	}

	public int getTotalLike() {
		return totalLike;
	}

	public void setTotalLike(int totalLike) {
		this.totalLike = totalLike;
	}
	
	public static GetAllCommentResponse copy(CommentDTO commentDTO) {
		GetAllCommentResponse result = new GetAllCommentResponse();
		result.setCommentId(commentDTO.getCommentId());
		result.setContent(commentDTO.getContent());
		result.setTotalLike(commentDTO.getTotalLike());
		result.setTotalReviewed(commentDTO.getTotalReviewed());
		return result;
	}
	
}
