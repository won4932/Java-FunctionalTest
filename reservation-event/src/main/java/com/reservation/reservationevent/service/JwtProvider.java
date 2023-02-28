package com.reservation.reservationevent.service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.reservation.reservationevent.jwt.JwtAuthenticationToken;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtProvider {

	// private static final SecretKey secret = Keys.hmacShaKeyFor(Decoders.BASE64.decode("secretKeysecretKey123456!@#"));

	private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

	public static final long VALIDATION_TIME = 60 * 60 * 24 * 1000L; // 1days

	// public String getUsernameFromToken(String token) {
	// 	//return
	// }

	// token extraction
	public <T> T getClaimToken(String token, Function<Claims, T> claimsTFunction) {
		final Claims claims = Jwts.parserBuilder()
			.setSigningKey(key)
			.build()
			.parseClaimsJws(token).getBody();

		return claimsTFunction.apply(claims);
	}

	// private Boolean isTokenExpired(String token) {
	// 	final Date expireation = getClaimToken(token, Claims::getExpiration);
	//
	// 	return expireation.before(new Date());
	//
	// }
	//
	// // cretae Token
	// public String generateToken(String id) {
	// 	return doGenerateToken(id, new HashMap<>());
	// }
	//
	// private String doGenerateToken(String id, Map<String, Object>claims) {
	// 	return Jwts.builder()
	// 		.setClaims(claims)
	// 		.setId(id)
	// 		.setIssuedAt(new Date(System.currentTimeMillis()))
	// 		.setExpiration(new Date(System.currentTimeMillis() + VALIDATION_TIME))
	// 		.signWith(secret)
	// 		.compact();
	// }

	// public Boolean validationToken(String token, UserDetails userDetails) {
	//
	// }
}


// public class JwtProvider implements AuthenticationProvider {
//
// 	private final UserService userService;
//
// 	private final Jwt jwt;
//
// 	public JwtProvider(Jwt jwt, UserService userService) {
// 		this.jwt = jwt;
// 		this.userService = userService;
// 	}
//
// 	@Override
// 	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
// 		JwtAuthenticationToken authenticationToken = (JwtAuthenticationToken) authentication;
//
// 		// return proce;
// 	}
//
// 	@Override
// 	public boolean supports(Class<?> authentication) {
// 		return false;
// 	}
//
// 	// private Authentication processUserAuth(AuthenticationRequest )
// }
