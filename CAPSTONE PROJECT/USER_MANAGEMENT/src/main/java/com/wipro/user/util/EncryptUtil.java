package com.wipro.user.util;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class EncryptUtil {

    // Generate salt
    public static String generateSalt() {
        return BCrypt.gensalt();
    }

    // Hash password with salt
    public static String getEncryptedPassword(String plainPassword, String salt) {
        return BCrypt.hashpw(plainPassword, salt);
    }

    // Verify password using stored salt
 // Verify password using BCrypt
    public static boolean verifyUserPassword(String plainPassword, String hashedPassword, String salt) {
        return BCrypt.checkpw(plainPassword, hashedPassword);
    }

}
