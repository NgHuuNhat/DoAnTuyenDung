package com.tuyendungvieclam.response.admin.user;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.tuyendungvieclam.response.CommonPagination;

public class FindAllUserPagination {

	@JsonProperty("data")
	private List<UserInfoResponse> userInfoList;
	
	@JsonProperty("pagination")
	private CommonPagination pagination;

	public List<UserInfoResponse> getUserInfoList() {
		return userInfoList;
	}

	public void setUserInfoList(List<UserInfoResponse> userInfoList) {
		this.userInfoList = userInfoList;
	}

	public CommonPagination getPagination() {
		return pagination;
	}

	public void setPagination(CommonPagination pagination) {
		this.pagination = pagination;
	}
}
