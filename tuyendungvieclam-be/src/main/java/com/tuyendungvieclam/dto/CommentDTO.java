package com.tuyendungvieclam.dto;

public class CommentDTO extends BaseDTO {
	
	private String commentId;
	
	private String content;
	
	private int totalReviewed;
	
	private int totalLike;
	
	private UserDTO user;
	
	private NewsDTO newInfo;

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

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

	public NewsDTO getNewInfo() {
		return newInfo;
	}

	public void setNewInfo(NewsDTO newInfo) {
		this.newInfo = newInfo;
	}
	

}
