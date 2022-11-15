package com.function.functiontest.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TestInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws
		Exception {
		// if (uri.contains(ROOT_API_PATH)) {
		// if (!licenseService.validationLicense(request)) {
			// SecurityContextHolder.clearContext();
			// throw new CommonException(SecurityExceptionType.INVALID_LICENSEKEY);
		// }
		// }

		return HandlerInterceptor.super.preHandle(request, response, handler);
	}

}