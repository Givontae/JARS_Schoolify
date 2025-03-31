package government.school.util;
import java.security.SecureRandom;

public final class Auth {

    private static final int MAX_ID = 999999; // The highest 6-digit number
    private static final int MIN_ID = 100000; // The lowest 6-digit number
    private static final boolean[] usedIds = new boolean[MAX_ID - MIN_ID + 1]; // Array to track used IDs
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

    public static String generatePassword(int intLength) {
        SecureRandom r = new SecureRandom();
        char[] password = new char[intLength];
        for (int i = 0; i < intLength; i++)
            password[i] = CHARS.charAt(r.nextInt(CHARS.length()));
        return new String(password);
    }

    public static int generateID() {
        int id;
        do {
            id = MIN_ID + secureRandom.nextInt(MAX_ID - MIN_ID + 1); // Generates a 6-digit number
        } while (usedIds[id - MIN_ID]); // Checks if the ID has been used already
        usedIds[id - MIN_ID] = true; // Mark the ID as used
        return id;
    }

}


