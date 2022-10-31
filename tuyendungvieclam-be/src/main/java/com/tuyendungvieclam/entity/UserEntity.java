package com.tuyendungvieclam.entity;

import java.util.List;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
	
	@Id
	@Column(name = "user_name")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "active")
	private boolean active;
	
	@Column(name = "classify")
	private String classify;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Transient
	private MultipartFile file;
	

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "userSet")
	private Set<RoleEntity> roleSet;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<NewsEntity> news;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	private List<CommentEntity> comments;
	
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

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

	public Set<RoleEntity> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<RoleEntity> roleSet) {
		this.roleSet = roleSet;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public List<NewsEntity> getNews() {
		return news;
	}

	public void setNews(List<NewsEntity> news) {
		this.news = news;
	}

	public List<CommentEntity> getComments() {
		return comments;
	}

	public void setComments(List<CommentEntity> comments) {
		this.comments = comments;
	}
}
