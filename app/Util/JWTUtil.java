package Util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import java.util.Date;

public class JWTUtil {
    public static final String SECRET_KEY = "yash123";
    public static final String ISSUER = "Myapp";


    public static String generateToken(String subject) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
            Date expirationDate = new Date(System.currentTimeMillis() + 3600000); // 1 hour from now

            String token = JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(subject)
                    .withClaim("data", subject)
                    .withExpiresAt(expirationDate)
                    .sign(algorithm);

            return token;
        } catch (JWTCreationException exception) {
            // Invalid Signing configuration / Couldn't convert Claims.
            exception.printStackTrace();
        }

        return null;
    }

//    public static boolean validateToken(String token) {
//        try {
//            Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);
//            JWT.require(algorithm)
//                    .withIssuer(ISSUER)
//                    .build()
//                    .verify(token);
//
//            return true;
//        } catch (JWTVerificationException exception) {
//            exception.printStackTrace();
//        }
//
//        return false;
//    }
}

