package com.reservation.reservationevent.service;

import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtService {

	public static String generateToken(String userName, String key, long expiredTime) {
		Claims claims = Jwts.claims();

		claims.put("userName", userName);
		return Jwts.builder()
			.setClaims(claims)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + expiredTime))
			.signWith(SignatureAlgorithm.ES256, key)
			.compact();
	}

	public static String getUserName(String token, String key) {
		return extractClaims(token, key).get("userName").toString();
	}

	public static Claims extractClaims(String token, String key) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
	}

	public static boolean isExpired(String token, String secretkey) {
		// expire timestamp를 return함
		Date expiredDate = extractClaims(token, secretkey).getExpiration();
		return expiredDate.before(new Date());
	}
}
