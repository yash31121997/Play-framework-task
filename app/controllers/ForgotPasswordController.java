package controllers;

import Model.User;
import Repository.UserRepository;
import Util.EmailUtil;
import com.fasterxml.jackson.databind.JsonNode;
import play.Logger;
import play.api.libs.mailer.MailerClient;
import play.libs.Json;
import play.mvc.Http;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Random;

import static play.mvc.Results.badRequest;
import static play.mvc.Results.ok;

public class ForgotPasswordController {

    private final UserRepository userRepository;


    private final EmailUtil emailUtil;

    @Inject
    public ForgotPasswordController(UserRepository userRepository, EmailUtil emailUtil) {
        this.userRepository = userRepository;
        this.emailUtil = emailUtil;
    }

    String otp = null;

    public Result forgotPassword(Http.Request request) {
        JsonNode json = request.body().asJson();
        String email = json.get("email").asText();

        User user = userRepository.findByEmail(email);
        if (user != null) {
            // Generate the OTP here
            otp = getRandomString();
            System.out.println(otp);

            // Send the OTP via email
            emailUtil.sendOTP(email, otp);

            return ok("OTP sent to email successfully");
        } else {
            return ok("User not found");
        }
    }

    public Result verifyOtp(Http.Request request) {

      //  System.out.println("entered in verifyOtp");
        JsonNode json = request.body().asJson();
    //    System.out.println("entered in verifyOtp2");
        String email = json.get("email").asText();

        String code = json.get("code").asText();
       // System.out.println(code);
        String newPassword = json.get("newPassword").asText();
       // System.out.println(newPassword);
        String confirmPassword = json.get("confirmPassword").asText();
      //  System.out.println(confirmPassword);

        User user = userRepository.findByEmail(email);
        System.out.println(user);
        System.out.println(user.getEmail());
        int id = user.getId();
        System.out.println(id);
        
        if (otp.equals(code) && newPassword.equals(confirmPassword)) {
            boolean success = userRepository.updatePassword(String.valueOf(id), newPassword);
            System.out.println(success);

            if (success) {
                // Return success response
                return ok(Json.toJson("Password updated successfully"));
            } else {
                // Return failure response
                return badRequest(Json.toJson("Failed to update password"));
            }

        } else {
            return ok("otp is incorrect");
        }
    }

        public String getRandomString() {
            int leftLimit = 97; // letter 'a'
            int rightLimit = 122; // letter 'z'
            int targetStringLength = 7;
            Random random = new Random();

            String generatedString = random.ints(leftLimit, rightLimit + 1).limit(8)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
            return generatedString;

        }
    }
