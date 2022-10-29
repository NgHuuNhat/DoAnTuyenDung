package com.tuyendungvieclam.request.admin.user;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AddUserRequest {
	
	@JsonProperty("user_name")
	private String userName;
	
	@JsonProperty("password")
	private String password;

	@JsonProperty("full_name")
	private String fullName;
	
	@JsonProperty("email")
	private String email;
	
	@JsonProperty("phone_number")
	private String phoneNumber;
	
	@JsonProperty("list_role")
	private List<String> listRole;
	
	@JsonProperty("file_name")
	private String fileName;
	
	@JsonProperty("base64")
	private String base64;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<String> getListRole() {
		return listRole;
	}

	public void setListRole(List<String> listRole) {
		this.listRole = listRole;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}
}
