/**************************************************************************
 * File name:
 * Auth.java
 *
 * Description:
 * This file contains the Auth class, which provides methods for generating
 * secure passwords and unique student IDs.
 *
 * Author:
 * G. Murzaku
 *
 * Date: April 01 2025
 *
 * Concepts:
 * Use of SecureRandom for secure random number generation
 * Use of arrays to track used IDs
 ***************************************************************************/

package government.school.util;

import java.security.SecureRandom;

public final class Auth {

    /* INSTANCE AND CLASS FIELD(S) */
    private static final int MAX_ID = 999999; // The highest 6-digit number
    private static final int MIN_ID = 100000; // The lowest 6-digit number
    private static final boolean[] usedIds = new boolean[MAX_ID - MIN_ID + 1]; 
    // Array to track used IDs
    
    private static final SecureRandom secureRandom = new SecureRandom();
    private static final String CHARS = 
        "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz" +
        "0123456789!@#$%^&*()-_=+[]{}|;:'\",.<>?/`~";

    /**********************************************************************
     * Method name:
     * generatePassword
     *
     * Description:
     * This method generates a random password of the specified length
     * using a predefined set of characters.
     *
     * Parameters:
     * int - length of the password to generate
     *
     * Return:
     * A randomly generated password as a String
     *
     * Restrictions:
     * The length must be greater than zero.
     *********************************************************************/
    public static String generatePassword(int intLength) {
        SecureRandom r = new SecureRandom();
        char[] password = new char[intLength];
        
        /*
         * This loop iterates intLength times to generate a password.
         * Each character is randomly selected from the predefined CHARS string.
         */
        for (int i = 0; i < intLength; i++) {
            password[i] = CHARS.charAt(r.nextInt(CHARS.length()));
        } /* End of for loop */
        
        return new String(password);
    } /* End of generatePassword method */

    /**********************************************************************
     * Method name:
     * generateID
     *
     * Description:
     * This method generates a unique 6-digit student ID that has not
     * been used before.
     *
     * Parameters:
     * None
     *
     * Return:
     * A unique 6-digit integer ID
     *
     * Restrictions:
     * The ID must be between 100000 and 999999.
     *********************************************************************/
    public static int generateID() {
        int id;
        
        /*
         * This loop generates a random 6-digit ID and ensures it is unique
         * by checking the usedIds array.
         */
        do {
            id = MIN_ID + secureRandom.nextInt(MAX_ID - MIN_ID + 1);
        } while (usedIds[id - MIN_ID]);
        
        usedIds[id - MIN_ID] = true; // Mark the ID as used
        return id;
    } /* End of generateID method */

} /* End of Auth class */
