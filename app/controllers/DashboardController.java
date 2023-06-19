package controllers;

import Repository.UserRepository;
import Util.JWTUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.SignatureAlgorithm;
import play.mvc.Controller;
import play.mvc.Result;

import play.mvc.*;
import play.libs.Json;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import java.security.Key;

import static Util.JWTUtil.SECRET_KEY;
import static com.google.inject.Key.get;
import static io.jsonwebtoken.Jwts.header;

public class DashboardController extends Controller {

    public UserRepository userRepository;
   public ObjectNode jsonObject = null;

    @Inject
    public DashboardController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    public Result getDashboard(Http.Request request) {
        String token = extractTokenFromHeader(request);
        if (token == null) {
            return badRequest("Authorization header not found or invalid format");
        }
        String data = extractDataFromToken(token);
        System.out.println(data);



        try {
            JsonNode response = Json.parse(data);

            ObjectNode jsonFormattedString = Json.newObject()
                    .put("id", response.findValue("id").asText())
                    .put("email", response.findValue("email").asText());

            String userEmail = jsonFormattedString.get("email").asText();
            System.out.println(userEmail + " 1234");


            System.out.println(jsonFormattedString);
            System.out.println(data);
            return ok(jsonFormattedString).as("application/json");


        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError("Error processing token data: " + e.getMessage());
        }

    }

    public String extractTokenFromHeader(Http.Request request) {
        String authorizationHeader = String.valueOf(request.getHeaders().get("Authorization"));
        String tokon = null;
        if (authorizationHeader != null || authorizationHeader.startsWith("Bearer ")) {
            System.out.println(authorizationHeader + "abcd");

            tokon = authorizationHeader.substring(16, authorizationHeader.length() - 1);
            System.out.println(tokon);
//             authorizationHeader.replace("Bearer ", "");
        }
        System.out.println(authorizationHeader + "1234");
        return tokon;
    }

    //    private String extractDataFromToken(String token) {
//        Claims claims = Jwts.parser()
//                .setSigningKey()
//                .parseClaimsJws(token)
//                .getBody();
//
//        String data = claims.get("data", String.class);
//        // Replace "data" with the actual claim name you want to retrieve
//        return data;
//    }
    public String extractDataFromToken(String tokon) {

        Algorithm algorithm = Algorithm.HMAC256(JWTUtil.SECRET_KEY);
        JWTVerifier verifier = JWT.require(algorithm)
                .withIssuer(JWTUtil.ISSUER)
                .build();

        DecodedJWT decodedJWT = verifier.verify(tokon);
        Claim dataClaim = decodedJWT.getClaim("data");

        if (dataClaim.isNull()) {
            // Handle the case where the "data" claim is missing or null
            return "hello";
        }

        return dataClaim.asString();

    }

    public Result logout(Http.Request request) {
//        String token1 = extractTokenFromHeader1(request);
        request.getHeaders().removing("token");

        return ok("Please log in again."); // Send a response asking the user to log in again
    }
}


//    public Result getDashboard(Http.Request request) {
//        String token = String.valueOf(request.header("Authorization"));
//        System.out.println(token);
//
//
//        Claims claims = Jwts.parser()
//                .setSigningKey("qwerty")
//                .parseClaimsJws(token)
//                .getBody();
//
//        String email = claims.get("email", String.class);
//        // Retrieve other necessary data from the claims as needed
//
//        // Fetch additional user data from the database using the username
//        User user = userRepository.findByEmail(email);
//        System.out.println(user);
//
//        // Process and return the data as needed
//        // For example, convert it to JSON or HTML
//
//        return ok("Dashboard");
//    }


//    public Result getUserData(Http.Request request) {
//
//        String token = String.valueOf(request.getHeaders().get("Authorization"));
        // Check if token is valid (You might have your own implementation for this)
//        return ok(token);
//        System.out.println(token);
//        if (!validateToken(token)) {
//            return unauthorized("Invalid token");
//        }

        // Retrieve user data from the database
        //  User user = FindByEmail();

        // Create a JSON response
//        ObjectNode json = Json.newObject();
//        json.put("id", user.getId());
//        json.put("name", user.getName());
//        json.put("email", user.getEmail());

//        return ok("Success");

