// package com.reservation.reservationevent.jwt;
//
// import java.util.List;
//
// import org.springframework.security.authentication.AbstractAuthenticationToken;
// import org.springframework.security.core.GrantedAuthority;
//
// public class JwtAuthenticationToken extends AbstractAuthenticationToken {
//
// 	private final Object principal;
//
// 	private String credentials;
//
// 	public JwtAuthenticationToken(Object principal, String credentials) {
// 		super(null);
// 		super.setAuthenticated(false);
//
// 		this.principal = principal;
// 		this.credentials = credentials;
// 	}
//
// 	public JwtAuthenticationToken(Object principal, String credentials, List<GrantedAuthority> authorities) {
// 		super(authorities);
// 		super.setAuthenticated(true);
//
// 		this.principal = principal;
// 		this.credentials = credentials;
// 	}
//
// 	@Override
// 	public Object getCredentials() {
// 		return null;
// 	}
//
// 	@Override
// 	public Object getPrincipal() {
// 		return null;
// 	}
// }
