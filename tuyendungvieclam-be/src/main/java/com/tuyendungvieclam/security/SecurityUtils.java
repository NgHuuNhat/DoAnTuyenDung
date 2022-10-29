package com.tuyendungvieclam.security;

import java.util.ArrayList;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityUtils {
	
	public static MyUserDetail getMyUserDetail() {
		return (MyUserDetail) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
	}
	
	public static List<String> getAuthorities() {
		List<String> result = new ArrayList<>();
		Collection<GrantedAuthority> grantedAuthorities = getMyUserDetail().getAuthorities();
		for(GrantedAuthority authority : grantedAuthorities) {
			result.add(authority.getAuthority());
		}
		return result;
	}
	
	public static String getUserNameFromSecurity() {
		String result = getMyUserDetail().getUsername();
		return result;
	}
}