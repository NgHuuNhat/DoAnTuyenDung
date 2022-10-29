package com.tuyendungvieclam.dto;

import java.util.Set;

public class RoleDTO {
	
	private String roleId;

	private String roleName;

	private String roleDescription;
	
	private Set<UserDTO> userSet;

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

	public Set<UserDTO> getUserSet() {
		return userSet;
	}

	public void setUserSet(Set<UserDTO> userSet) {
		this.userSet = userSet;
	}
	
}