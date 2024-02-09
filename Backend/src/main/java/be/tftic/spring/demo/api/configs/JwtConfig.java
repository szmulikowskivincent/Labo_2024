package be.tftic.spring.demo.api.configs;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfig {

    private byte[] secret = "Yabadadooooooooooooooooooooooooooooooooooooooooooooooooo".getBytes(StandardCharsets.UTF_8);

    public int expireAt = 86400; // 1Days

    public SecretKey secretKey = new SecretKeySpec(secret, "HmacSHA384");

    public Claims parseClaimsJws(String token) {
        JwtParser jwtParser = Jwts.parserBuilder().setSigningKey(secretKey).build();
        return jwtParser.parseClaimsJws(token).getBody();
    }

    public JwtConfig claimId(String id, Long id1) {
        return this;
    }

    public JwtConfig claimEmail(String email, String email1) {
        return this;
    }
}



