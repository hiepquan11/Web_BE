package com.huynhduc.WebBE.Service.Jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
@Service
public class JwtService {
    public static final String SECRET_KEY = "MTIzNDU2NDU5OThEMzIxM0F6eGMzNTE2NTQzMjEzMjE2NTQ5OHEzMTNhMnMxZDMyMnp4M2MyMQ==";

    // generate jwt
    public String generateToken(String userName) {
        Map<String, Object> claims = new HashMap<>();
        //claims.put("isAdmin", userName);
        return createToken(claims, userName);
    }

    // create jwt
    private String createToken(Map<String, Object> claims, String userName) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 30*60*1000))
                .signWith(SignatureAlgorithm.HS256,getSigneKey())
                .compact();
    }

    // get secret key
    private Key getSigneKey(){
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // get info token
    private Claims extractAllClaims(String token){

        return Jwts.parser().setSigningKey(getSigneKey()).parseClaimsJws(token).getBody();
    }

    // Method generic
    public <T> T extractClaim(String token, Function<Claims, T> claimsTFunction){
        final Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    // check expire time jwt
    public Date extractExpiration(String token){
        return extractClaim(token, Claims::getExpiration);
    }

    // check username jwt
    public String extractUsername(String token){
        return extractClaim(token, Claims::getSubject);
    }

    // check token is expire
    private Boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    // check token is valid
    public Boolean validateToken(String token, UserDetails userDetails){
        final String userName = extractUsername(token);
        return (userName.equals(userDetails.getUsername()) && isTokenExpired(token));
    }
}
