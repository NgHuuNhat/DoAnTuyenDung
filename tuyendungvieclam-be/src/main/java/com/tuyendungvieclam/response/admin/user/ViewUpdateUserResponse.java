package com.tuyendungvieclam.response.admin.user;

import java.util.HashSet;
import java.util.Set;
import com.tuyendungvieclam.dto.RoleDTO;
import com.tuyendungvieclam.dto.UserDTO;

public class ViewUpdateUserResponse {
	
	private String userName;
	
	private String password;

	private String fullName;
	
	private String phoneNumber;
	
	private String email;

	private String avatar;

	private boolean active;
	
	private String classify;
	
	private Set<String> listHaveRoles;
	
	private Set<String> listNoRoles;

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

	public Set<String> getListHaveRoles() {
		return listHaveRoles;
	}

	public void setListHaveRoles(Set<String> listHaveRoles) {
		this.listHaveRoles = listHaveRoles;
	}

	public Set<String> getListNoRoles() {
		return listNoRoles;
	}

	public void setListNoRoles(Set<String> listNoRoles) {
		this.listNoRoles = listNoRoles;
	}

	public static ViewUpdateUserResponse copy(UserDTO userDTO, Set<RoleDTO> allRole) {
		ViewUpdateUserResponse result = new ViewUpdateUserResponse();
		result.setUserName(userDTO.getUserName());
		result.setPassword(userDTO.getPassword());
		result.setActive(userDTO.isActive());
		result.setEmail(userDTO.getEmail());
		result.setFullName(userDTO.getFullName());
		result.setPhoneNumber(userDTO.getPhoneNumber());
		result.setAvatar(userDTO.getAvatar());
		
		Set<String> noHaveRoles = new HashSet<>();
		for (RoleDTO roleDTO: allRole) {
			noHaveRoles.add(roleDTO.getRoleId());
		}
		
		Set<String> haveRoles = new HashSet<>();
		for (RoleDTO roleDTO: userDTO.getRoleSet()) {
			haveRoles.add(roleDTO.getRoleId());
		}
		result.setListHaveRoles(haveRoles);
		noHaveRoles.removeAll(haveRoles);
		result.setListNoRoles(noHaveRoles);
		return result;
	}
}
