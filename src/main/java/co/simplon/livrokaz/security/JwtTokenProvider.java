package co.simplon.livrokaz.security;


import static co.simplon.livrokaz.security.SecurityConstants.SECRET_KEY;
import static co.simplon.livrokaz.security.SecurityConstants.TOKEN_EXPIRATION_TIME;


import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import co.simplon.livrokaz.model.User0ld;

@Component
public class JwtTokenProvider {

    // Ici nous allons faire 3 choses
    //1. Generer le le token

    public String generateToken(Authentication authentication){
        User0ld user = (User0ld)authentication.getPrincipal();
        Date now = new Date(System.currentTimeMillis());
        Date expireDate = new Date(now.getTime() + TOKEN_EXPIRATION_TIME);
        String userId = Long.toString(user.getId());
        Map<String, Object>claims = new HashMap<>();
        claims.put("id", (Long.toString(user.getId())));
        claims.put("username", user.getUsername());
        claims.put("fullName", user.getFullName());
        return Jwts.builder()
                .setSubject(userId)
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }


    //2. Valider le token
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex){
            System.out.println("Signature JWT invalide !!!");
        } catch (MalformedJwtException ex) {
            System.out.println("token JWT invalide !!!");
        } catch (ExpiredJwtException ex) {
            System.out.println("Désolé, le token a expiré !!!");
        } catch (UnsupportedJwtException ex){
            System.out.println("Token JWT non supporté !!!");
        } catch (IllegalArgumentException ex) {
            System.out.println("JWT claims string is empty !!!");
        }
        return false;
    }

    //3. Recuperer l'id du user depuis apartir du token

    public Long getUserIdFromJWT(String token){
        Claims claims =Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
        String id = (String)claims.get("id");
        return Long.parseLong(id);
    }
}
