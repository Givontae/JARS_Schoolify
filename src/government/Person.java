package government;
import java.util.Random;

// Abstract class to represent a person with basic attributes.
public abstract class Person {
    /* INSTANCE AND CLASS FIELD(S) */
    private int intAge; // Person's age.
    private String strName; // Person's name.
    private final int SIN; // Person's SIN (immutable after generation).

    /* CONSTRUCTOR(S) */
    public Person(int age, String name) {
        setAge(age); // Set age using setter to enforce logic.
        setName(name); // Set name using setter.
        this.SIN = generateSIN(); // Generate SIN via Luhn Algorithm.
    }

    /* STORAGE METHODS */
    // Method to generate a valid Canadian SIN using the Luhn Algorithm.
    private int generateSIN() {
        Random rand = new Random();
        int sin = 0;
        int sum = 0;

        // Generate the first 8 digits.
        for (int i = 0; i < 8; i++) {
            int digit = (i == 0) ? rand.nextInt(9) + 1 : rand.nextInt(10); // First digit (1-9), others (0-9).
            sin = sin * 10 + digit; // Append digit to SIN.

            // Apply Luhn algorithm: Double every second digit from the left.
            if (i % 2 == 1) {
                digit *= 2;
                if (digit > 9) {
                    digit -= 9; // Reduce if greater than 9.
                }
            }
            sum += digit; // Add the digit to the sum.
        }

        // Compute the check digit (modulo 10 rule).
        int checkDigit = (10 - (sum % 10)) % 10;
        sin = sin * 10 + checkDigit; // Append check digit to complete SIN.

        return sin; // Return complete SIN.
    }

    /* LOGIC METHOD(S) */
    // Polymorphism: Each subclass can define its own behavior if needed.
     // Abstract method for displaying person details.

    /* GETTER(S) */
    // Getter for name.
    public String getName() {
        return strName;
    }

    // Getter for age.
    public int getAge() {
        return intAge;
    }

    // Getter for SIN (should be private and immutable after initialization).
    private int getSIN() {
        return SIN;
    }

    /* SETTER(S) */
    // Setter for name.
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.strName = name;
        } else {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
    }

    // Setter for age.
    public void setAge(int age) {
        if (age > 0 && age <= 150) { // Enforcing a valid age range.
            this.intAge = age;
        } else {
            throw new IllegalArgumentException("Invalid age value.");
        }
    }

    // toString() method to represent the object in string form.
    @Override
    public String toString() {
        return "Person{Name='" + strName + "', Age=" + intAge + ", SIN=" + SIN + "}";
    }
}
