package com.waw.jwt;

import java.io.Serializable;
import java.security.KeyPair;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtValidator implements Serializable {
/*
	private static final long serialVersionUID = -8275800452308841188L;
	
	// @Value("${jwt.secret}")
	private String secret;
	
	private static final Logger logger = LoggerFactory.getLogger(JwtValidator.class);
	
	public void asdf () {
		
		SecretKey key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		
		KeyPair keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256);
		
	}
	public Map<String, Object> getUserParseInfo(String token) {
        Claims parseInfo = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        Map<String, Object> result = new HashMap<>();
        //expiration date < now
        boolean isExpired = !parseInfo.getExpiration().before(new Date());
        result.put("username", parseInfo.getSubject());
        result.put("role", parseInfo.get("role", List.class));
        result.put("isExpired", isExpired);
        return result;
    }

    private boolean isValidate(String token) {
        try {
            Map<String, Object> info = getUserParseInfo(token);
        }
        // token is expired
        catch (ExpiredJwtException e) {
            logger.warn("The token is expired.");
            return false;
        }
        // signature is wrong
        catch (SignatureException e) {
            logger.warn("Signature of the token is wrong.");
            return false;
        }
        // format is wrong
        catch (MalformedJwtException | UnsupportedJwtException | IllegalArgumentException e) {
            logger.warn("The token string is wrong format.");
            return false;
        }
        return true;
    }
	*/
}
