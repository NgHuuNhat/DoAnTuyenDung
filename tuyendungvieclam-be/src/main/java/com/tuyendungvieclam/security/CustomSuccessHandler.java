package com.tuyendungvieclam.security;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}
	
	@Override
	protected void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		String url = determineTargetUrl();
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, url);
	}
	
	public String determineTargetUrl() {
		String result = "";
		List<String> roles = SecurityUtils.getAuthorities();
		if (roles.contains("ADMIN")) {
			result = "/admin";
		} else if (roles.contains("USER")) {
			result = "/";
		}
		return result;
	}
}
