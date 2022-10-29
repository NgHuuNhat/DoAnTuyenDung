package com.tuyendungvieclam.response.client.comment;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tuyendungvieclam.dto.CommentDTO;
import com.tuyendungvieclam.utils.DateUtils;

public class CommentInfo {
	
	@JsonProperty("comment_content")
	private String commentContent;
	
	@JsonProperty("user_comment")
	private String userComment;
	
	@JsonProperty("created_date")
	private String createdDate;

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getUserComment() {
		return userComment;
	}

	public void setUserComment(String userComment) {
		this.userComment = userComment;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public static CommentInfo copy(CommentDTO commentDTO) {
		CommentInfo result = new CommentInfo();
		result.setCommentContent(commentDTO.getContent());
		result.setUserComment(commentDTO.getUser().getUserName());
		result.setCreatedDate(DateUtils.convertDateToString(commentDTO.getCreatedDate(), DateUtils.PARTTERN_YYMMDD_HHMMSS));
		return result;
	}
}
