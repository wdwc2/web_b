package com.web_b.web_b.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;


@Data

public class JwtUtil {

    // 过期时间
    private static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    // 加密秘钥
    private static final String signingKey = "web_b";

    // 算法
    private static final SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

    // 生成jwt令牌
    public static String generateToken(Map<String, Object> claims) {
        // 生成令牌,设置过期时间为一周
        return Jwts.builder() // 令牌生成器
                .setClaims(claims) // 设置载荷
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE)) // 设置过期时间
                .signWith(signatureAlgorithm, signingKey).compact(); // 设置签名,并生成令牌

    }

    // 解析jwt令牌
    public static Map<String, Object> parseToken(String token) {
        // 解析令牌
        return Jwts.parser() // 令牌解析器
                .setSigningKey(signingKey) // 设置签名
                .parseClaimsJws(token) // 解析令牌
                .getBody(); // 获取载荷
    }
}
