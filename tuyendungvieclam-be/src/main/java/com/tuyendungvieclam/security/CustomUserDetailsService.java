package com.tuyendungvieclam.security;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.tuyendungvieclam.dto.RoleDTO;
import com.tuyendungvieclam.dto.UserDTO;
import com.tuyendungvieclam.service.UserService;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDTO userDTO = userService.findByUserName(username);
		if (userDTO == null) {
			throw new UsernameNotFoundException("tai khoan hoac mat khua khong dung.");
		}
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		
		for (RoleDTO role: userDTO.getRoleSet()) {
			SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
			grantedAuthorityList.add(simpleGrantedAuthority);
		}
		MyUserDetail myUserDetail = new MyUserDetail(username, userDTO.getPassword(), userDTO.isActive(), true, true, true, grantedAuthorityList, userDTO.getFullName());
		return myUserDetail;
	}
}