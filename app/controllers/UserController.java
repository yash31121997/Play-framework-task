package controllers;

import Model.User;
import Repository.UserRepository;
import Util.JWTUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.mindrot.jbcrypt.BCrypt;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import controllers.DashboardController.*;
import play.twirl.api.Content;

import javax.inject.Inject;

public class UserController extends Controller {

    public UserRepository userRepository;
    private final FormFactory formFactory;

    @Inject
    public UserController(UserRepository userRepository, FormFactory formFactory) {
        this.userRepository = userRepository;
        this.formFactory = formFactory;
    }

    public Result createUser(Http.Request request) {
        Form<User> userForm = formFactory.form(User.class).bindFromRequest(request);

        if (userForm.hasErrors()) {
            return badRequest(userForm.errorsAsJson());
        }

        User user = userForm.get();
        String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashedPassword);
        userRepository.save(user);

        return ok(String.valueOf(user)).as("application/json");

    }

    public Result login(Http.Request request) {

//        String email = request.body().asJson().get("email").asText();
//        String password = request.body().asJson().get("password").asText();

        JsonNode json = request.body().asJson();
        String email = json.get("email").asText();
        String password = json.get("password").asText();

        // Validate the user's credentials (e.g., check against a database)
        boolean isValidCredentials = validateCredentials(email, password);

        if (isValidCredentials) {
            User user = userRepository.findByEmail(email);
            // Create a User instance
//            User user = new User();
//            user.setEmail(email);
//            user.setPassword(password);

            // Generate a JWT token for the user
            String token = JWTUtil.generateToken(String.valueOf(user));

            if (token != null) {
                // Return the token in the response
                return ok("token : " + token);
            } else {
                // Handle error scenario
                return internalServerError("Failed to generate token");
            }
        } else {
            // Handle invalid credentials scenario
            return unauthorized("Invalid email or password");
        }
    }

    public boolean validateCredentials(String email, String password) {
        User user = userRepository.findByEmail(email);

        if (user != null) {
            // Compare the provided password with the password stored in the database (plaintext comparison)
            return BCrypt.checkpw(password, user.getPassword());
        }
        return false;
    }
}



