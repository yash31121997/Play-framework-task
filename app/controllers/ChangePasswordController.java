package controllers;

import Repository.UserRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.mindrot.jbcrypt.BCrypt;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
//import controllers.UserController.validateCredentials;

import javax.inject.Inject;

public class ChangePasswordController extends Controller {

    public UserController userController;

    public UserRepository userRepository;

    public DashboardController dashboardController;

    public ObjectNode jsonFormattedString;

    @Inject
    public ChangePasswordController(DashboardController dashboardController, UserController userController, UserRepository userRepository) {
        this.userRepository = userRepository;
        this.userController = userController;
        this.dashboardController = dashboardController;
    }


    public Result changePassword(Http.Request request) {
        String token = dashboardController.extractTokenFromHeader(request);
        if (token == null) {
            return badRequest("Authorization header not found or invalid format");
        }
        String data = dashboardController.extractDataFromToken(token);
        System.out.println(data);

        try {
            JsonNode response = Json.parse(data);

            ObjectNode jsonFormattedString = Json.newObject()
                    .put("id", response.findValue("id").asText())
                    .put("email", response.findValue("email").asText())
                    .put("password", response.findValue("password").asText());

            String userEmail = jsonFormattedString.get("email").asText();
            System.out.println(userEmail + " 1234");


            System.out.println(jsonFormattedString);
            System.out.println(data);

            JsonNode response1 = Json.parse(data);

            String id = response1.findValue("id").asText();   //String.valueOf(jsonFormattedString.get("id"));



            String userPassword = response1.findValue("password").asText();  //String.valueOf(jsonFormattedString.get("password")).replaceAll("\"", "");
            System.out.println(userPassword);


            JsonNode json = request.body().asJson();
            String password = json.get("password").asText();
            String newPassword = json.get("newPassword").asText();
            String confirmPassword = json.get("confirmPassword").asText();



            if ( BCrypt.checkpw(password, userPassword) && newPassword.equals(confirmPassword)) {
                String newPassword1 = BCrypt.hashpw(newPassword, BCrypt.gensalt());
                boolean success = userRepository.updatePassword(id, newPassword1);

                if (success) {
                 // Return success response
                    return ok(Json.toJson("Password updated successfully"));
                } else {
                    // Return failure response
                    return badRequest(Json.toJson("Failed to update password"));
                }
            }
            else{
                return ok("old password is incorrect");
            }

        } catch (Exception e) {
            e.printStackTrace();
            return internalServerError("Error processing token data: " + e.getMessage());
        }

    }
}




















































//        String email = json.get("email").asText();
//        String oldPassword = json.get("oldPassword").asText();
//
//        boolean isValidCredentials = userController.validateCredentials(email, oldPassword);
//
//        if(isVali)
//
//        JsonNode json = request.body().asJson();
//
//        String newPassword = json.get("newPassword").asText();
//        String confirmPassword = json.get("confirmPassword").asText();
//
//
//
//
//        return
//    }




//    String tokon = null;
//    public UserRepository userRepository;
//
//    @Inject
//    public PasswordController(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//        public Result changePassword(Http.Request request) {
//
//            String token1 = extractTokenFromHeader(request);
//            if (token1 == null) {
//                return badRequest("Authorization header not found or invalid format");
//
//            } else {
//                JsonNode json = request.body().asJson();
//                String userId = json.get("userId").asText();
//                String newPassword = json.get("newPassword").asText();
//                String confirmPassword = json.get("confirmPassword").asText();
//
//                if (!newPassword.equals(confirmPassword)) {
//                    return badRequest(Json.toJson("New password and confirm password do not match"));
//                }
//
//
//                boolean success = userRepository.updatePassword(userId, newPassword);
//
//                if (success) {
//                    // Return success response
//                    return ok(Json.toJson("Password updated successfully"));
//                } else {
//                    // Return failure response
//                    return badRequest(Json.toJson("Failed to update password"));
//                }
//            }
//        }
//
//    public String extractTokenFromHeader(Http.Request request) {
//        String authorizationHeader = String.valueOf(request.getHeaders().get("Authorization"));
//
//        if (authorizationHeader != null || authorizationHeader.startsWith("Bearer ")) {
//
//
//            tokon = authorizationHeader.substring(16,authorizationHeader.length()-1);
////             authorizationHeader.replace("Bearer ", "");
//        }
//        return tokon;
//    }


