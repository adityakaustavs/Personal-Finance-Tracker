package com.finance.tracker.security;
import io.jsonwebtoken.*; import io.jsonwebtoken.security.Keys; import java.nio.charset.StandardCharsets; import java.util.Date; import javax.crypto.SecretKey; import org.springframework.beans.factory.annotation.Value; import org.springframework.stereotype.Service;
@Service public class JwtService {
 private final SecretKey key; private final long expiry;
 public JwtService(@Value("${app.jwt.secret}") String secret,@Value("${app.jwt.expiration-ms}") long expiry){this.key=Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));this.expiry=expiry;}
 public String generateToken(UserPrincipal p){return Jwts.builder().subject(String.valueOf(p.id())).claim("username",p.username()).issuedAt(new Date()).expiration(new Date(System.currentTimeMillis()+expiry)).signWith(key).compact();}
 public Long userId(String token){return Long.valueOf(Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().getSubject());}
 public String username(String token){return Jwts.parser().verifyWith(key).build().parseSignedClaims(token).getPayload().get("username",String.class);}
 public boolean valid(String token){try{userId(token);return true;}catch(JwtException|IllegalArgumentException e){return false;}}
}
