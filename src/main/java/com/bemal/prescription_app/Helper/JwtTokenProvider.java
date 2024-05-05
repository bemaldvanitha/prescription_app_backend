package com.bemal.prescription_app.Helper;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

public class JwtTokenProvider {
    private static final String SECRET_KEY = "Secret-Key-Test_new_One_Ssl-RSGJYN-2983-29jeu7dh-Yoo-rwtsbhY";
    private static final long EXPIRATION_TIME = 3600 * 1000;

    public static String generateToken(String phoneNumber, Long userId) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + EXPIRATION_TIME);
        Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        return Jwts.builder().setSubject(phoneNumber).claim("userId", userId).setExpiration(expiryDate).signWith(key).compact();
    }

    public static TokenValidationResult validateToken(String token){
        try{
            if(token == null){
                return TokenValidationResult.INVALID;
            }

            Jws<Claims> claimsJws = Jwts.parserBuilder().setSigningKey(Keys.hmacShaKeyFor(SECRET_KEY.getBytes())).build().parseClaimsJws(token);

            Claims claims = claimsJws.getBody();
            String phoneNumber = claims.getSubject();
            Long userId = claims.get("userId", Long.class);


            if (claims.getExpiration().before(new Date())) {
                return TokenValidationResult.EXPIRED;
            }

            return new TokenValidationResult(true, "Token Valid", phoneNumber, userId);
        }catch (Exception e){
            return TokenValidationResult.INVALID;
        }
    }

    public static class TokenValidationResult {
        public static final TokenValidationResult EXPIRED = new TokenValidationResult(false, "Token expired");

        public static final TokenValidationResult INVALID = new TokenValidationResult(false, "Token invalid");

        private final boolean isValid;

        private final String message;

        private final String phoneNumber;

        private final Long userId;


        public TokenValidationResult(boolean isValid, String message) {
            this.isValid = isValid;
            this.message = message;
            this.phoneNumber = null;
            this.userId = null;
        }

        public TokenValidationResult(boolean isValid, String message, String phoneNumber, Long userId) {
            this.isValid = isValid;
            this.message = message;
            this.phoneNumber = phoneNumber;
            this.userId = userId;
        }

        public boolean isValid() {
            return isValid;
        }

        public String getMessage() {
            return message;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public Long getUserId() {
            return userId;
        }
    }
}




