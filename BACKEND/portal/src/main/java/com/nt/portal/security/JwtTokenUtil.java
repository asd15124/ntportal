package com.nt.portal.security;

import java.io.Serializable;
import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

import com.nt.portal.dto.UserDto;
import com.nt.portal.dto.common.Constants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {

	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 5909372867205543078L;

	/**
	 * Method to generate jwt tokens
	 * 
	 * @param id
	 * @param issuer
	 * @param subject
	 * @param ttlMillis
	 * @return
	 */
	public String createJWT(String id, String issuer, String subject, long ttlMillis) {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(Constants.SIGNING_KEY);
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	/**
	 * Method to validate and parse jwtTokens
	 * 
	 * @param jwt
	 */
	public UserDto parseJWT(String token) {

		UserDto jwtUser = null;
		try {
			Claims body = Jwts.parser().setSigningKey(Constants.SIGNING_KEY).parseClaimsJws(token).getBody();

			jwtUser = new UserDto();

			jwtUser.setUserName(body.getSubject());
			jwtUser.setId(Long.parseLong((String) body.get("id")));
			/* jwtUser.setRoles((String) body.get("role")); */
		} catch (Exception e) {
			System.out.println(e);
		}

		return jwtUser;
	}
}
