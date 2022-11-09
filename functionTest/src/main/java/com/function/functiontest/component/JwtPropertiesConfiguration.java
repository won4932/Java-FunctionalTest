package com.function.functiontest.component;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtPropertiesConfiguration {
	public static long accessTokenValidTime;
	public static long refreshTokenValidTime;

	@Value("${jwt.accessTokenValidTime}")
	public void setAccessTokenValidTime(long value) {
		accessTokenValidTime = value;
	}

	@Value("${jwt.refreshTokenValidTime}")
	public void setRefreshTokenValidTime(long value) {
		refreshTokenValidTime = value;
	}
}
