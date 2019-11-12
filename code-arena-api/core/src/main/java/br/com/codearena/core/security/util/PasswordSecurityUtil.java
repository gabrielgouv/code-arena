package br.com.codearena.core.security.util;

import org.mindrot.jbcrypt.BCrypt;

public final class PasswordSecurityUtil {

    private static final int LOG_ROUNDS = 16;

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt(LOG_ROUNDS));
    }

    public static boolean verifyHash(String password, String hash) {
        return BCrypt.checkpw(password, hash);
    }

}
