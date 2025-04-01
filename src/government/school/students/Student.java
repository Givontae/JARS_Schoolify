package government.school.students;

import government.Person;
import government.school.Course;
import government.school.CourseSection;
import government.school.Timetable;
import government.school.util.Auth;

import java.io.*;
import java.util.ArrayList;

/**************************************************************************
 * File name:
 * Student.java
 *
 * Description:
 * This file contains the Student class, which represents a student within the
 * school system. It extends the Person class and implements Serializable. 
 * The class manages attributes such as credits earned, volunteer hours, GPA,
 * timetable, and graduation status. It also provides methods for saving and
 * loading student records, setting and getting student details, and performing
 * graduation logic.
 *
 * Author:
 * [Your Name]
 *
 * Date: [Date]
 *
 * Concepts:
 * Inheritance, Encapsulation, Exception Handling, Serialization, Static Methods
 **************************************************************************/

public class Student extends Person implements Serializable {

    /* INSTANCE AND CLASS FIELD(S) */
    private final int STUDENT_ID; // The student's unique ID
    private String PASSWORD; // The student's password

    private int intCreditsEarned; // The total credits the student has earned
    private int intVolunteerHoursCompleted; // The total volunteer hours completed by the student
    private boolean[] status; // Array indicating the student's status (suspended, on vacation, graduated)
    private double dblGPA; // The student's grade point average
    private Timetable timetable; // The student's class timetable

    private static final int MAX_COURSES = 4; // Maximum number of courses the student can take
    public static final int MINIMUM_CREDITS = 30; // Minimum credits required to graduate
    public static final int MINIMUM_VOLUNTEER_HOURS = 40; // Minimum volunteer hours required to graduate
    private static ArrayList<Student> students = new ArrayList<>(); // List of all student records

    /* CONSTRUCTORS */

    /**********************************************************************
     * Method name:
     * Student
     *
     * Description:
     * Constructor for creating a Student with minimal attributes. This 
     * constructor initializes default values and generates a unique student ID.
     *
     * Parameters:
     * intAge   The student's age
     * strName  The student's name
     *
     * Restrictions:
     * None
     *
     * Return:
     * None
     *********************************************************************/
    public Student(int intAge, String strName) {
        super(intAge, strName);
        this.STUDENT_ID = Auth.generateID();
        setPassword(Auth.generatePassword(8));

        this.intCreditsEarned = 0;
        this.intVolunteerHoursCompleted = 0;
        this.dblGPA = 0.0;
        this.timetable = new Timetable();
        this.status = new boolean[]{false, false, false}; // Default status: not graduated, not suspended, not on vacation

        students.add(this); // Add the created student to the student list
    }

    /**********************************************************************
     * Method name:
     * Student
     *
     * Description:
     * Full constructor for creating a Student with all relevant attributes.
     * This constructor allows initialization of all student data.
     *
     * Parameters:
     * intAge            The student's age
     * intID             The student's ID number
     * strName           The student's name
     * password          The student's account password
     * intCreditsEarned  The number of credits earned by the student
     * intVolunteerHours The number of volunteer hours completed
     * dblGPA            The student's grade point average
     * timetable         The student's class timetable
     * status            The student's status (e.g., enrolled, graduated, suspended)
     *
     * Restrictions:
     * None
     *
     * Return:
     * None
     *********************************************************************/
    public Student(int intAge, int intID, String strName, String password, int intCreditsEarned, int intVolunteerHours, double dblGPA, Timetable timetable, boolean[] status) {
        super(intAge, strName);
        this.STUDENT_ID = Auth.generateID();
        setPassword(password);

        this.intCreditsEarned = intCreditsEarned;
        this.intVolunteerHoursCompleted = intVolunteerHours;
        this.dblGPA = dblGPA;
        this.timetable = timetable;
        this.status = status;

        students.add(this); // Add the created student to the student list
    }

    /* SETTERS */

    /**********************************************************************
     * Method name:
     * setPassword
     *
     * Description:
     * Sets the student's password, ensuring it is not null and has at least 8 characters.
     *
     * Parameters:
     * password The student's desired password
     *
     * Restrictions:
     * Throws IllegalArgumentException if the password is null or shorter than 8 characters.
     *
     * Return:
     * None
     *********************************************************************/
    public void setPassword(String password) {
        if (password == null || password.trim().length() < 8)
            throw new IllegalArgumentException("Password cannot be null or less than 8 characters");
        this.PASSWORD = password;
    }

    /**********************************************************************
     * Method name:
     * setVolunteerHours
     *
     * Description:
     * Sets the number of volunteer hours completed by the student.
     *
     * Parameters:
     * intVolunteerHours The number of volunteer hours
     *
     * Restrictions:
     * Throws IllegalArgumentException if the number of volunteer hours is negative.
     *
     * Return:
     * None
     *********************************************************************/
    public void setVolunteerHours(int intVolunteerHours) {
        if (intVolunteerHours < 0)
            throw new IllegalArgumentException("Volunteer hours cannot be negative");
        this.intVolunteerHoursCompleted = intVolunteerHours;
    }

    /**********************************************************************
     * Method name:
     * setTimetable
     *
     * Description:
     * Sets the student's timetable, creating a clone to avoid external modifications.
     *
     * Parameters:
     * timetable The student's timetable object
     *
     * Restrictions:
     * None
     *
     * Return:
     * None
     *********************************************************************/
    public void setTimetable(Timetable timetable) {
        this.timetable = timetable.clone();
    }

    /**********************************************************************
     * Method name:
     * setStatus
     *
     * Description:
     * Sets the student's status array, ensuring that the array is cloned.
     *
     * Parameters:
     * status The student's status array
     *
     * Restrictions:
     * None
     *
     * Return:
     * None
     *********************************************************************/
    public void setStatus(boolean[] status) {
        this.status = status.clone();
    }

    /* GETTERS */

    /**********************************************************************
     * Method name:
     * getCount
     *
     * Description:
     * Returns the total number of student records.
     *
     * Parameters:
     * None
     *
     * Return:
     * The total count of students
     *********************************************************************/
    public static int getCount() {
        return students.size();
    }

    /**********************************************************************
     * Method name:
     * getID
     *
     * Description:
     * Returns the unique student ID.
     *
     * Parameters:
     * None
     *
     * Return:
     * The student's ID number
     *********************************************************************/
    public int getID() {
        return this.STUDENT_ID;
    }

    /**********************************************************************
     * Method name:
     * getCreditsEarned
     *
     * Description:
     * Returns the total credits the student has earned.
     *
     * Parameters:
     * None
     *
     * Return:
     * The total credits earned
     *********************************************************************/
    public int getCreditsEarned() {
        return this.intCreditsEarned;
    }

    /**********************************************************************
     * Method name:
     * getGPA
     *
     * Description:
     * Returns the student's grade point average (GPA).
     *
     * Parameters:
     * None
     *
     * Return:
     * The student's GPA
     *********************************************************************/
    public double getGPA() {
        return this.dblGPA;
    }

    /**********************************************************************
     * Method name:
     * getTimetable
     *
     * Description:
     * Returns a clone of the student's timetable to avoid external modifications.
     *
     * Parameters:
     * None
     *
     * Return:
     * A clone of the student's timetable
     *********************************************************************/
    public Timetable getTimetable() {
        return this.timetable.clone();
    }

    /**********************************************************************
     * Method name:
     * getStatus
     *
     * Description:
     * Returns a clone of the student's status array to avoid external modifications.
     *
     * Parameters:
     * None
     *
     * Return:
     * A clone of the student's status array
     *********************************************************************/
    public boolean[] getStatus() {
        return this.status.clone();
    }

    /**********************************************************************
     * Method name:
     * getVolunteerHoursCompleted
     *
     * Description:
     * Returns the total number of volunteer hours the student has completed.
     *
     * Parameters:
     * None
     *
     * Return:
     * The total volunteer hours completed
     *********************************************************************/
    public int getVolunteerHoursCompleted() {
        return this.intVolunteerHoursCompleted;
    }

    /* LOGIC METHODS */

    /**********************************************************************
     * Method name:
     * graduate
     *
     * Description:
     * Marks the student as graduated if they meet the minimum requirements for
     * credits and volunteer hours. If they are in the wrong status or do not
     * meet the graduation requirements, an exception is thrown.
     *
     * Parameters:
     * None
     *
     * Restrictions:
     * Throws IllegalStateException if the student cannot graduate.
     *
     * Return:
     * None
     *********************************************************************/
    public void graduate() {

        if (this.getStatus()[0] || this.getStatus()[1] || this.getStatus()[2]) {
            throw new IllegalStateException("Student is not in the right status to graduate.");
        }

        if (this.getCreditsEarned() >= Student.MINIMUM_CREDITS &&
                this.getVolunteerHoursCompleted() >= MINIMUM_VOLUNTEER_HOURS) {
            this.setStatus(new boolean[]{false, true}); // Mark student as graduated
        } else {
            throw new IllegalStateException("Student does not meet graduation requirements.");
        }

    }

    /* STORAGE METHODS */

    /**********************************************************************
     * Method name:
     * saveStudentsToFile
     *
     * Description:
     * Saves the list of student records to a file.
     *
     * Parameters:
     * filename The name of the file where student data will be saved
     *
     * Restrictions:
     * None
     *
     * Return:
     * None
     *********************************************************************/
    public static void saveStudentsToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Student records have been saved.");
        } catch (IOException e) {
            System.out.println("Error saving student records");
        }
    }

    /**********************************************************************
     * Method name:
     * loadStudentsFromFile
     *
     * Description:
     * Loads student records from a file and adds them to the student list.
     *
     * Parameters:
     * filename The name of the file to load student data from
     *
     * Restrictions:
     * None
     *
     * Return:
     * None
     *********************************************************************/
    public static void loadStudentsFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No student records found.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            ArrayList<Student> loadedStudents = (ArrayList<Student>) ois.readObject();
            students.addAll(loadedStudents);
            System.out.println("Student records have been loaded.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading student records");
        }
    }

    /**********************************************************************
     * Method name:
     * toString
     *
     * Description:
     * Returns a string representation of the student object.
     *
     * Parameters:
     * None
     *
     * Return:
     * A string representation of the student
     *********************************************************************/
    @Override
    public String toString() {
        return "";
    }

} /* End of Student class */
