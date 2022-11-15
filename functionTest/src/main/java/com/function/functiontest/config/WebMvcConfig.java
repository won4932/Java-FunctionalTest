package com.function.functiontest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {

	// private final LicenseService licenseService;
	//
	// @Override
	// public void addInterceptors(InterceptorRegistry registry) {
	// 	// registry.addInterceptor(new TestInterceptor(licenseService))
	// 	// 	.addPathPatterns(ROOT_API_PATH+"/**"); // 해당 경로에 접근하기 전에 인터셉터가 가로챈다.
	// 	// 	// .excludePathPatterns("/boards"); // 해당 경로는 인터셉터가 가로채지 않는다.
	// }
}
