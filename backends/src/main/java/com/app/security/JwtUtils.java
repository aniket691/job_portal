package com.app.security;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {

	@Value("${SECRET_KEY}")
	private String jwtSecret;

	@Value("${EXP_TIMEOUT}")
	private int jwtExpirationMs;

	private Key key;

	@PostConstruct
	public void init() {
		key = Keys.hmacShaKeyFor(jwtSecret.getBytes());
	}

	public String generateJwtToken(Authentication authentication) {
//        Log.info("generate jwt token " + authentication);

		// Handle both types of user details
		String userName = authentication.getName();
		Long userId = null;
		String authorities = "";

		if (authentication.getPrincipal() instanceof CustomJobSeekerDetails) {
			CustomJobSeekerDetails userPrincipal = (CustomJobSeekerDetails) authentication.getPrincipal();
			userId = userPrincipal.getJobSeeker().getJobSeekerId();
			authorities = getAuthoritiesInString(userPrincipal.getAuthorities());
		} else if (authentication.getPrincipal() instanceof CustomRecruiterDetails) {
			CustomRecruiterDetails userPrincipal = (CustomRecruiterDetails) authentication.getPrincipal();
			userId = userPrincipal.getRecruiter().getRecruiterId();
			authorities = getAuthoritiesInString(userPrincipal.getAuthorities());
		}

		return Jwts.builder().setSubject(userName).setIssuedAt(new Date())
				.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs)).claim("authorities", authorities)
				.claim("user_id", userId).signWith(key, SignatureAlgorithm.HS512).compact();
	}

	public String getUserNameFromJwtToken(Claims claims) {
		return claims.getSubject();
	}

	public Claims validateJwtToken(String jwtToken) {
		Claims claims = Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwtToken).getBody();
		return claims;
	}

	private String getAuthoritiesInString(Collection<? extends GrantedAuthority> authorities) {
		return authorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.joining(","));
	}

	public List<GrantedAuthority> getAuthoritiesFromClaims(Claims claims) {
		String authString = (String) claims.get("authorities");
		return AuthorityUtils.commaSeparatedStringToAuthorityList(authString);
	}

	public Long getUserIdFromJwtToken(Claims claims) {
		return Long.valueOf((int) claims.get("user_id"));
	}

	public Authentication populateAuthenticationTokenFromJWT(String jwt) {
		Claims payloadClaims = validateJwtToken(jwt);
		String email = getUserNameFromJwtToken(payloadClaims);
		List<GrantedAuthority> authorities = getAuthoritiesFromClaims(payloadClaims);
		Long userId = getUserIdFromJwtToken(payloadClaims);

		// Determine the user type and create the appropriate Authentication token
		return new UsernamePasswordAuthenticationToken(email, userId, authorities);
	}
}
