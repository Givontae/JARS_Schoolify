package government.school.staff;

import government.Person;
import government.school.Course;
import government.school.Timetable;

import java.util.ArrayList;

/**************************************************************************
 * File name: Teacher.java
 *
 * Description:
 * This file defines the Teacher class, which represents a teacher
 * in the school system. It extends the Employee class and includes
 * additional attributes specific to teaching staff.
 *
 * Author:
 * G. Murzaku
 *
 * Date: February 02 2024
 *
 * Concepts:
 * - Inheritance from Employee class
 * - Use of ArrayList to store subjects taught
 * - Cloning to prevent unintended modifications
 **************************************************************************/ 

public class Teacher extends Employee {

    // Fields
    private String strTeachingCertification; // Teacher's certification
    private ArrayList<Course> subjectsTaught; // List of courses taught
    private Timetable timetable; // Teacher's timetable

    /**********************************************************************
     * Constructor: Teacher
     *
     * Description:
     * Initializes a Teacher object with the specified attributes.
     *
     * Parameters:
     * @param intAge - Teacher's age
     * @param strName - Teacher's name
     * @param strPassword - Password for authentication
     * @param strDepartment - Department in which the teacher works
     * @param shiftInterval - Work shift timing
     * @param intYearsEmployed - Years of employment
     * @param dblAnnualSalary - Annual salary
     * @param blnStatus - Employment status (fired, vacation, retired)
     * @param strTeachingCertification - Certification of the teacher
     * @param subjectsTaught - List of subjects taught
     * @param timetable - Teacher's schedule
     **********************************************************************/
    public Teacher(int intAge, String strName, String strPassword, String strDepartment, String[] shiftInterval,
                   int intYearsEmployed, double dblAnnualSalary, boolean[] blnStatus,
                   String strTeachingCertification, ArrayList<Course> subjectsTaught, Timetable timetable){
        super(intAge, strName, strPassword, strDepartment, shiftInterval, intYearsEmployed, dblAnnualSalary, blnStatus);
        setTeachingCertification(strTeachingCertification);
        setSubjectsTaught(subjectsTaught);
        setTimetable(timetable);
        setDepartment(strDepartment);
    }

    /**********************************************************************
     * Method: setSubjectsTaught
     *
     * Description:
     * Sets the subjects that the teacher teaches.
     *
     * Parameters:
     * @param subjectsTaught - List of subjects the teacher teaches
     *
     * Restrictions:
     * - subjectsTaught cannot be null
     **********************************************************************/
    private void setSubjectsTaught(ArrayList<Course> subjectsTaught) {
        if (subjectsTaught == null)
            throw new NullPointerException("subjectsTaught cannot be null");

        this.subjectsTaught = subjectsTaught;
    }

    // Getter Methods

    /**********************************************************************
     * Method: getTeachingCertification
     *
     * Description:
     * Retrieves the teacher's certification.
     *
     * Return:
     * - A string representing the teaching certification.
     **********************************************************************/
    public String getTeachingCertification(){
        return this.strTeachingCertification;
    }

    /**********************************************************************
     * Method: getSubjectsTaught
     *
     * Description:
     * Retrieves the subjects taught by the teacher.
     *
     * Return:
     * - An ArrayList of Course objects representing the subjects taught.
     **********************************************************************/
    public ArrayList<Course> getSubjectsTaught(){
        return this.subjectsTaught; 
    }

    /**********************************************************************
     * Method: getTimetable
     *
     * Description:
     * Retrieves the teacher's timetable.
     *
     * Return:
     * - A cloned Timetable object to prevent modifications.
     **********************************************************************/
    public Timetable getTimetable(){
        return this.timetable.clone();
    }

    // Setter Methods

    /**********************************************************************
     * Method: setTeachingCertification
     *
     * Description:
     * Sets the teacher's certification.
     *
     * Parameters:
     * @param strTeachingCertification - Teacher's certification
     *
     * Restrictions:
     * - strTeachingCertification cannot be null or empty
     **********************************************************************/
    public void setTeachingCertification(String strTeachingCertification){
        if (strTeachingCertification != null && !strTeachingCertification.isEmpty()){
            this.strTeachingCertification = strTeachingCertification;
        } else
            throw new NullPointerException("strTeachingCertification cannot be null");
    }

    /**********************************************************************
     * Method: setTimetable
     *
     * Description:
     * Sets the teacher's timetable.
     *
     * Parameters:
     * @param timetable - The new timetable for the teacher
     *
     * Restrictions:
     * - The timetable cannot be null
     * - The timetable must have exactly 4 entries
     **********************************************************************/
    public void setTimetable(Timetable timetable){
        if (timetable != null && timetable.getTt().length == 4){
            this.timetable = timetable.clone();
        }
    }

    // Overridden Methods from the Employee Superclass

    /**********************************************************************
     * Method: toString
     *
     * Description:
     * Returns a string representation of the Teacher object.
     *
     * Return:
     * - A formatted string with teacher details.
     **********************************************************************/
    @Override
    public String toString(){
        return "Position: Teacher\n" + super.toString() + "\nTeaching Certification: "
                + strTeachingCertification + "\nSubjects Taught: " + subjectsTaught;
    }
} /* End of Teacher class */
