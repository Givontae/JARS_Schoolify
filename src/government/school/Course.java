/**************************************************************************
 * File name:
 * Course.java
 *
 * Description:
 * This file defines the Course class, an abstract representation of a 
 * school course with attributes such as course code, grade level, and 
 * capacity constraints.
 *
 * Author:
 * G. Murzaku
 *
 * Date: April 01, 2025
 *
 * Concepts:
 * - Use of abstract classes
 * - Use of final variables
 * - Getters and setters
 **************************************************************************/

package government.school;

import government.school.staff.Teacher;
import java.util.ArrayList;

public abstract class Course {
    
    /* INSTANCE FIELD(S) */
    private int intCourseGrade; // Grade level of the course

    /* CONSTANT(S) */
    protected final String COURSE_CODE; // Unique course identifier
    protected final int COURSE_MAX_CAPACITY; // Maximum students allowed
    protected final int COURSE_MIN_CAPACITY; // Minimum students required

    /**********************************************************************
     * Constructor name:
     * Course
     *
     * Description:
     * Initializes a course with a specific course code, grade level, and
     * capacity constraints.
     *
     * Parameters:
     * String - Course code identifier
     * int - Grade level for the course
     * int - Maximum capacity for the course
     * int - Minimum capacity required for the course
     *
     * Restrictions:
     * Grade level must be within valid range when set later
     *********************************************************************/
    public Course(String strCourseCode, int dblCourseGrade, 
                  int intCourseMaxCapacity, int intCourseMinCapacity) {
        
        COURSE_CODE = strCourseCode; // Assigns course code
        this.intCourseGrade = dblCourseGrade; // Sets the course grade
        COURSE_MAX_CAPACITY = intCourseMaxCapacity; // Sets max capacity
        COURSE_MIN_CAPACITY = intCourseMinCapacity; // Sets min capacity
    }

    /* GETTERS */
    /**********************************************************************
     * Method name:
     * getCourseGrade
     *
     * Description:
     * Returns the grade level associated with this course.
     *
     * Parameters:
     * None
     *
     * Return:
     * int - Grade level of the course
     *********************************************************************/
    public int getCourseGrade() {
        return intCourseGrade;
    }

    /**********************************************************************
     * Method name:
     * getCourseMaxCapacity
     *
     * Description:
     * Returns the maximum number of students allowed in the course.
     *
     * Parameters:
     * None
     *
     * Return:
     * int - Maximum course capacity
     *********************************************************************/
    public int getCourseMaxCapacity() {
        return COURSE_MAX_CAPACITY;
    }

    /**********************************************************************
     * Method name:
     * getCourseMinCapacity
     *
     * Description:
     * Returns the minimum number of students required for the course.
     *
     * Parameters:
     * None
     *
     * Return:
     * int - Minimum course capacity
     *********************************************************************/
    public int getCourseMinCapacity() {
        return COURSE_MIN_CAPACITY;
    }

    /**********************************************************************
     * Method name:
     * getCourseCode
     *
     * Description:
     * Returns the unique course code for this course.
     *
     * Parameters:
     * None
     *
     * Return:
     * String - Course code identifier
     *********************************************************************/
    public String getCourseCode() {
        return COURSE_CODE;
    }

    /* SETTERS */
    /**********************************************************************
     * Method name:
     * setCourseGrade
     *
     * Description:
     * Sets the grade level of the course, ensuring it is within the range
     * of 1 to 12.
     *
     * Parameters:
     * int - Grade level to be assigned
     *
     * Restrictions:
     * Grade must be between 1 and 12 inclusive
     *********************************************************************/
    public void setCourseGrade(int grade) {
        /* Validate grade level before assignment */
        if (grade < 1 || grade > 12) {
            throw new IllegalArgumentException(
                "Grade must be between 1 and 12 inclusive"
            );
        }
        intCourseGrade = grade; // Assigns the validated grade level
    }

} /* End of Course class */
