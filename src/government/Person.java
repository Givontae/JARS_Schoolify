/**************************************************************************
* File name: Person.java
*
* Description:
* This file contains an abstract class Person to represent a person
* with basic attributes. It includes methods to generate a valid
* Canadian SIN using the Luhn Algorithm, as well as getters and setters.
*
* Author:
* [Your Name]
*
* Date: March 31 2025
*
* Concepts:
* - Use of Random for digit generation
* - Luhn Algorithm for SIN validation
* - Encapsulation and abstraction in Java
**************************************************************************/

package government;

import java.util.Random;

// Abstract class to represent a person with basic attributes.
public abstract class Person {

    /**************************************************************************
    * Instance and Class Fields
    *************************************************************************/
    private int intAge;         // Person's age.
    private String strName;     // Person's name.
    private final int SIN;      // Person's SIN (immutable).

    /**************************************************************************
    * Constructor
    *
    * Description:
    * This constructor initializes a Person object by setting the age
    * and name using their setters, and generating a SIN.
    *
    * Parameters:
    * int age - The age of the person.
    * String name - The name of the person.
    *************************************************************************/
    public Person(int age, String name) {
        setAge(age);            // Set age using setter.
        setName(name);          // Set name using setter.
        this.SIN = generateSIN(); // Generate SIN via Luhn Algorithm.
    }

    /**************************************************************************
    * Method: generateSIN
    *
    * Description:
    * Generates a valid Canadian SIN using the Luhn Algorithm.
    *
    * Return:
    * int - A complete SIN with check digit.
    *************************************************************************/
    private int generateSIN() {
        Random rand = new Random();
        int sin = 0;
        int sum = 0;

        /* 
         * Generate the first 8 digits.
         * First digit (1-9), subsequent digits (0-9).
         */
        for (int i = 0; i < 8; i++) {
            int digit = (i == 0) 
                        ? rand.nextInt(9) + 1 
                        : rand.nextInt(10);
            sin = sin * 10 + digit;  // Append digit to SIN.

            /* 
             * Apply Luhn algorithm:
             * Double every second digit from the left.
             */
            if (i % 2 == 1) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9; // Reduce if digit > 9.
                }
            }
            sum += digit;  // Add to sum.
        }

        // Compute check digit (modulo 10 rule).
        int checkDigit = (10 - (sum % 10)) % 10;
        sin = sin * 10 + checkDigit;  // Append check digit.

        return sin;  // Return complete SIN.
    }

    /**************************************************************************
    * Method: getName
    *
    * Description:
    * Getter for the person's name.
    *
    * Return:
    * String - The person's name.
    *************************************************************************/
    public String getName() {
        return strName;
    }

    /**************************************************************************
    * Method: getAge
    *
    * Description:
    * Getter for the person's age.
    *
    * Return:
    * int - The person's age.
    *************************************************************************/
    public int getAge() {
        return intAge;
    }

    /**************************************************************************
    * Method: getSIN
    *
    * Description:
    * Getter for the person's SIN.
    *
    * Return:
    * int - The person's SIN.
    *
    * Note: SIN is immutable and private.
    *************************************************************************/
    private int getSIN() {
        return SIN;
    }

    /**************************************************************************
    * Method: setName
    *
    * Description:
    * Setter for the person's name. Ensures that name is not null
    * or empty.
    *
    * Parameters:
    * String name - The new name for the person.
    *
    * Restrictions:
    * The name cannot be null or empty.
    *************************************************************************/
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.strName = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    /**************************************************************************
    * Method: setAge
    *
    * Description:
    * Setter for the person's age. Enforces a valid age range.
    *
    * Parameters:
    * int age - The new age for the person.
    *
    * Restrictions:
    * Age must be > 0 and <= 150.
    *************************************************************************/
    public void setAge(int age) {
        if (age > 0 && age <= 150) { 
            this.intAge = age;
        } else {
            throw new IllegalArgumentException("Invalid age value.");
        }
    }

    /**************************************************************************
    * Method: toString
    *
    * Description:
    * Returns a string representation of the Person object.
    *
    * Return:
    * String - A string that includes the person's name, age, and SIN.
    *************************************************************************/
    @Override
    public String toString() {
        return "Person{Name='" + strName + "', Age=" + intAge + 
               ", SIN=" + SIN + "}";
    }
} /* End of Person class */

