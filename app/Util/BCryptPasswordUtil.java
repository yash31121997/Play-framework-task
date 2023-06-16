package Util;

import org.mindrot.jbcrypt.BCrypt;

public class BCryptPasswordUtil {
    public static String encryptPassword(String password) {
        String salt = BCrypt.gensalt();
        return BCrypt.hashpw(password, salt);
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}

