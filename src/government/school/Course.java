package government.school;

import government.school.staff.Teacher;

import java.util.ArrayList;

public abstract class Course {
    // Fields

    private int intCourseGrade;

    // Constants
    protected final String COURSE_CODE;
    protected final int COURSE_MAX_CAPACITY;
    protected final int COURSE_MIN_CAPACITY;

    // Constructor
    public Course(String strCourseCode, int dblCourseGrade, int intCourseMaxCapacity, int intCourseMinCapacity) {

        COURSE_CODE = strCourseCode;

        this.intCourseGrade = dblCourseGrade;

        COURSE_MAX_CAPACITY = intCourseMaxCapacity;
        COURSE_MIN_CAPACITY = intCourseMinCapacity;
    }


    // Getters
    public double getCourseGrade() {
        return intCourseGrade;
    }

    public int getCourseMaxCapacity() {
        return COURSE_MAX_CAPACITY;
    }

    public int getCourseMinCapacity() {
        return COURSE_MIN_CAPACITY;
    }

    public String getCourseCode() {
        return COURSE_CODE;
    }

    // Setters

    public void setCourseGrade(int grade) {
        if (grade < 1 || grade > 12) {
            throw new IllegalArgumentException("Grade must be between 1 and 12 inclusive");
        }

        intCourseGrade = grade;

    }

}

