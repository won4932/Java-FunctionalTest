package com.reservation.reservationevent.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws IOException, ServletException {

		List<String> role = new ArrayList<>();

		authentication.getAuthorities().forEach(auth -> {
			role.add(auth.getAuthority());
		});

		role.forEach(s -> {
			System.out.println(s);
		});

		// System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());

		if(role.contains("ROLE_ADMIN")) {
			// response.sendRedirect("/admin");
			response.sendRedirect("/admin-stomp");
			return;
		}

		if(role.contains("ROLE_MEMBER")) {
			response.sendRedirect("/member");
			return;
		}

		response.sendRedirect("/");
	}

}
