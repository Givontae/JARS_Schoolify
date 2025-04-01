package government.school.students;

import government.school.Timetable;

/**************************************************************************
 * File name:
 * SHSMStudent.java
 *
 * Description:
 * This file contains the SHSMStudent class which represents a student enrolled
 * in the Specialist High Skills Major (SHSM) program. The class includes additional
 * attributes for cooperative education placement (COOP) and completion status.
 * It extends the Student class and adds specific logic related to SHSM graduation
 * requirements and COOP placement.
 *
 * Author:
 * [Your Name]
 *
 * Date: [Date]
 *
 * Concepts:
 * Inheritance, Constructor Overloading, Exception Handling, Encapsulation
 **************************************************************************/

public class SHSMStudent extends Student {

    /* INSTANCE AND CLASS FIELD(S) */
    private String strCOOPPlacement; // The student's cooperative education placement
    private boolean blnHasCOOPCompleted; // Flag indicating if the student has completed their COOP

    /* CONSTRUCTOR(S) */

    /**********************************************************************
     * Method name:
     * SHSMStudent
     *
     * Description:
     * Constructor for creating an SHSMStudent with minimal attributes.
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
    public SHSMStudent(int intAge, String strName) {
        super(intAge, strName);
        setCOOPPlacement("None");
        setHasCompletedCOOP(false);
    }

    /**********************************************************************
     * Method name:
     * SHSMStudent
     *
     * Description:
     * Full constructor for SHSMStudent with all relevant attributes.
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
     * status            The student's status (e.g., enrolled, graduated, dropped out)
     * strCOOPPlacement  The student's cooperative education placement
     * blnHasCOOPCompleted Whether the student has completed the COOP
     *
     * Restrictions:
     * None
     *
     * Return:
     * None
     *********************************************************************/
    public SHSMStudent(int intAge, int intID, String strName, String password, int intCreditsEarned, 
                       int intVolunteerHours, double dblGPA, Timetable timetable, boolean[] status, 
                       String strCOOPPlacement, boolean blnHasCOOPCompleted) {
        super(intAge, intID, strName, password, intCreditsEarned, intVolunteerHours, dblGPA, timetable, status);
        setCOOPPlacement(strCOOPPlacement);
        setHasCompletedCOOP(blnHasCOOPCompleted);
    }

    /* LOGIC METHOD(S) */

    /**********************************************************************
     * Method name:
     * graduate
     *
     * Description:
     * Determines if the SHSM student is eligible for graduation based on earned
     * credits, volunteer hours, and completion of the COOP program. Updates the
     * student's status if they meet the graduation requirements.
     *
     * Parameters:
     * None
     *
     * Restrictions:
     * Throws IllegalStateException if the student does not meet the graduation
     * requirements or is in the wrong status to graduate.
     *
     * Return:
     * None
     *********************************************************************/
    @Override
    public void graduate() {
        if (this.getStatus()[0] || this.getStatus()[1] || this.getStatus()[2]) {
            throw new IllegalStateException("Student is not in the right status to graduate.");
        }

        if (this.getCreditsEarned() >= MINIMUM_CREDITS &&
                this.getVolunteerHoursCompleted() >= MINIMUM_VOLUNTEER_HOURS &&
                this.hasCompletedCOOP()) {
            this.setStatus(new boolean[]{false, false, true}); // Marks student as graduated
        } else {
            throw new IllegalStateException("SHSM Student does not meet graduation requirements.");
        }
    }

    /**********************************************************************
     * Method name:
     * setCOOPPlacement
     *
     * Description:
     * Sets the student's COOP placement.
     *
     * Parameters:
     * placement The placement location or organization for the student's COOP
     *
     * Restrictions:
     * Throws IllegalArgumentException if the placement is null or empty.
     *
     * Return:
     * None
     *********************************************************************/
    public void setCOOPPlacement(String placement) {
        if (placement == null || placement.trim().isEmpty()) {
            throw new IllegalArgumentException("Student and placement cannot be null or empty.");
        }
        strCOOPPlacement = placement;
    }

    /**********************************************************************
     * Method name:
     * setHasCompletedCOOP
     *
     * Description:
     * Sets whether the student has completed their COOP program.
     *
     * Parameters:
     * hasCompleted Boolean value indicating COOP completion status
     *
     * Restrictions:
     * Throws IllegalStateException if the student has not set their COOP placement
     * before marking it as completed.
     *
     * Return:
     * None
     *********************************************************************/
    public void setHasCompletedCOOP(boolean hasCompleted) {
        if (strCOOPPlacement.equals("None") && hasCompleted)
            throw new IllegalStateException("Set COOP Placement first.");
        
        this.blnHasCOOPCompleted = hasCompleted;
    }

    /* GETTER(S) */

    /**********************************************************************
     * Method name:
     * getCOOPPlacement
     *
     * Description:
     * Returns the student's COOP placement.
     *
     * Parameters:
     * None
     *
     * Return:
     * The COOP placement for the student.
     *********************************************************************/
    public String getCOOPPlacement() {
        return this.strCOOPPlacement;
    }

    /**********************************************************************
     * Method name:
     * hasCompletedCOOP
     *
     * Description:
     * Returns whether the student has completed their COOP program.
     *
     * Parameters:
     * None
     *
     * Return:
     * Boolean indicating if the student has completed their COOP.
     *********************************************************************/
    public boolean hasCompletedCOOP() {
        return this.blnHasCOOPCompleted;
    }

} /* End of SHSMStudent class */
