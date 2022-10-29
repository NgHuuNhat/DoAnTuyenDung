package com.tuyendungvieclam.dto;

import java.util.List;
import java.util.Set;

public class UserDTO extends BaseDTO {

	private String userName;
	
	private String password;

	private String fullName;
	
	private String phoneNumber;

	private String email;

	private String avatar;
	
	private boolean active;
	
	private String classify;

	private Set<RoleDTO> roleSet;
	
	private List<NewsDTO> news;
	
	private List<CommentDTO> comments;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public Set<RoleDTO> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<RoleDTO> roleSet) {
		this.roleSet = roleSet;
	}

	public List<NewsDTO> getNews() {
		return news;
	}

	public void setNews(List<NewsDTO> news) {
		this.news = news;
	}

	public List<CommentDTO> getComments() {
		return comments;
	}

	public void setComments(List<CommentDTO> comments) {
		this.comments = comments;
	}
}
