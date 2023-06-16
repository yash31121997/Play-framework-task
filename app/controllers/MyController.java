package controllers;

import Util.JWTUtil;
import play.mvc.Controller;
import play.mvc.Result;

public class MyController extends Controller {
    public Result authenticate() {
        String subject = "user123"; // The subject can be any unique identifier for the user

        String token = JWTUtil.generateToken(subject);

        if (token != null) {
            // Return the token in the response
            return ok(token);
        } else {
            // Handle error scenario
            return internalServerError("Failed to generate token");
        }
    }
}

