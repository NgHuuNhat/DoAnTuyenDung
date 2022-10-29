package com.tuyendungvieclam.response.admin.role;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.tuyendungvieclam.dto.RoleDTO;

public class RoleInfo {
	
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
	
	public static RoleInfo copy(RoleDTO roleDTO) {
		RoleInfo roleInfo = new RoleInfo();
		roleInfo.setRoleId(roleDTO.getRoleId());
		roleInfo.setRoleName(roleDTO.getRoleName());
		roleInfo.setRoleDescription(roleDTO.getRoleDescription());
		return roleInfo;
	}
}
