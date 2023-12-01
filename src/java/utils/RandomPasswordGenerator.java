package utils;

import java.security.SecureRandom;

class RandomPasswordGenerator {
    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()-_=+[]{}|;:'<>,.?/";

    private static final String PASSWORD_CHAR_SET = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;

    public static String generateRandomPassword(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be a positive integer");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(PASSWORD_CHAR_SET.length());
            char randomChar = PASSWORD_CHAR_SET.charAt(randomIndex);
            password.append(randomChar);
        }

        return password.toString();
    }
}
