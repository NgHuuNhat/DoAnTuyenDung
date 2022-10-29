package com.tuyendungvieclam.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity {
	
	@Id
	@Column(name = "comment_id")
	private String commentId;
	
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;
	
	@Column(name = "total_reviewed")
	private int totalReviewed;
	
	@Column(name = "total_like")
	private int totalLike;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_name")
	private UserEntity user;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "new_id")
	private NewsEntity newInfo;

	
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

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public NewsEntity getNewInfo() {
		return newInfo;
	}

	public void setNewInfo(NewsEntity newInfo) {
		this.newInfo = newInfo;
	}
	
	
}
