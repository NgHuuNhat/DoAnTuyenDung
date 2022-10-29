package com.tuyendungvieclam.response.admin.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tuyendungvieclam.dto.RoleDTO;

public class GetAllRoleResponse {
	
	@JsonProperty("role_id")
	private String roleId;
	
	@JsonProperty("role_name")
	private String roleName;
	
	@JsonProperty("role_description")
	private String roleDescription;

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public static GetAllRoleResponse copy(RoleDTO roleDTO) {
		GetAllRoleResponse result = new GetAllRoleResponse();
		result.setRoleId(roleDTO.getRoleId());
		result.setRoleName(roleDTO.getRoleName());
		result.setRoleDescription(roleDTO.getRoleDescription());
		return result;
	}
}
