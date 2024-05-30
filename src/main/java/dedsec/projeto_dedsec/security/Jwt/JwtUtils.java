package dedsec.projeto_dedsec.security.Jwt;

import dedsec.projeto_dedsec.service.UserDetailsImp;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;
import java.util.Date;

public class JwtUtils {

    @Value("${projeto.jwtSecret}")
    private String jwtSecret;

    @Value("${projeto.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String  generateTokenFromUserDetailsImpl(UserDetailsImp userDetail) {
        return Jwts.builder().setSubject(userDetail.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .signWith(getSigninKey(), SignatureAlgorithm.HS512).compact();
    }

    public Key getSigninKey(){
        SecretKey key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
        return key;
    }

    public boolean validateJwtToken(String authToken) {
        try{
            Jwts.parser().setSigningKey(getSigninKey()).build().parseClaimsJws(authToken);
            return true;
        }catch (MalformedJwtException ex){
            // Fazer com Log4j2
            System.out.println("Token Inválido: " + ex.getMessage());
        }catch (ExpiredJwtException ex){
            System.out.println("Token expirado: " + ex.getMessage());
        }catch (UnsupportedJwtException ex){
            System.out.println("Token não suportado: " + ex.getMessage());
        }catch (IllegalArgumentException ex){
            System.out.println("Token Argumento inválido: " + ex.getMessage());
        }

        return false;
    }

}
