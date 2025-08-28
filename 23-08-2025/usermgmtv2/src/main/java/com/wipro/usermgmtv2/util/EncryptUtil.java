package com.wipro.usermgmtv2.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EncryptUtil {

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // Hash password
    public static String getEncryptedPassword(String plainPassword) {
        return encoder.encode(plainPassword);
    }

    // Verify raw vs hashed
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return encoder.matches(plainPassword, hashedPassword);
    }
}
