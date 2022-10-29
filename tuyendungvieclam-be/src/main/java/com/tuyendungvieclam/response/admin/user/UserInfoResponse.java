package com.tuyendungvieclam.response.admin.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tuyendungvieclam.dto.UserDTO;
import com.tuyendungvieclam.utils.DateUtils;

public class UserInfoResponse {
	
	@JsonProperty("user_name")
	private String userName;
	
	@JsonProperty("created_date")
	private String createdDate;
	
	@JsonProperty("created_by")
	private String createdBy;
	
	@JsonProperty("updated_date")
	private String updatedDate;
	
	@JsonProperty("updated_by")
	private String updatedBy;
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public static UserInfoResponse copy(UserDTO userDTO) {
		UserInfoResponse result = new UserInfoResponse();
		result.setUserName(userDTO.getUserName());
		result.setCreatedBy(userDTO.getCreatedBy());
		if (userDTO.getCreatedDate() != null) {
			result.setCreatedDate(DateUtils.convertDateToString(userDTO.getCreatedDate(), DateUtils.PARTTERN_YYMMDD_HHMMSS));
		}
		result.setUpdatedBy(userDTO.getUpdatedBy());
		if (userDTO.getUpdatedDate() != null) {
			result.setUpdatedDate(DateUtils.convertDateToString(userDTO.getUpdatedDate(), DateUtils.PARTTERN_YYMMDD_HHMMSS));
		}
		return result;
	}
}
