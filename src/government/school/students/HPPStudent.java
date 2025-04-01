package government.school.students;

import government.school.Timetable;

/**************************************************************************
 * File name:
 * HPPStudent.java
 *
 * Description:
 * This file contains the HPPStudent class which represents a student enrolled
 * in a High-Performance Program (HPP). It includes additional attributes for
 * sports participation such as sport type, team, and position. This class
 * extends the Student class and adds specific logic related to sports involvement.
 *
 * Author:
 * [Your Name]
 *
 * Date: [Date]
 *
 * Concepts:
 * Inheritance, Constructor Overloading, Exception Handling, Encapsulation
 **************************************************************************/

public class HPPStudent extends Student {

    /* INSTANCE AND CLASS FIELD(S) */
    private String strSport; // The sport the student participates in
    private String strTeam;  // The team the student is a part of
    private String strPosition; // The position the student plays in their sport

    /* CONSTRUCTOR(S) */

    /**********************************************************************
     * Method name:
     * HPPStudent
     *
     * Description:
     * Full constructor for HPPStudent.
     *
     * Parameters:
     * intAge            The student's age
     * strName           The student's name
     * intID             The student's ID number
     * password          The student's account password
     * intCreditsEarned  The number of credits earned by the student
     * intVolunteerHours The number of volunteer hours completed
     * dblGPA            The student's grade point average
     * intDaysAbsent     The number of days the student was absent
     * intDaysLate       The number of days the student was late
     * timetable         The student's class timetable
     * status            The student's status (e.g., enrolled, graduated, dropped out)
     * strSport          The sport the student participates in
     * strTeam           The team the student is a part of
     * strPosition       The position the student plays in their sport
     *
     * Restrictions:
     * None
     *
     * Return:
     * None
     *********************************************************************/
    public HPPStudent(int intAge, String strName, int intID, String password, int intCreditsEarned, 
                      int intVolunteerHours, double dblGPA, int intDaysAbsent, int intDaysLate, 
                      Timetable timetable, boolean[] status, String strSport, String strTeam, 
                      String strPosition) {
        super(intAge, intID, strName, password, intCreditsEarned, intVolunteerHours, dblGPA, timetable, status);

        setSport(strSport);
        setTeam(strTeam);
        setPosition(strPosition);
    }

    /**********************************************************************
     * Method name:
     * HPPStudent
     *
     * Description:
     * Constructor with minimal fields for creating an HPPStudent.
     *
     * Parameters:
     * intAge   The student's age
     * strName  The student's name
     * strSport The sport the student participates in
     *
     * Restrictions:
     * None
     *
     * Return:
     * None
     *********************************************************************/
    public HPPStudent(int intAge, String strName, String strSport){
        super(intAge, strName);
        setSport(strSport);
    }

    /* LOGIC METHOD(S) */

    /**********************************************************************
     * Method name:
     * graduate
     *
     * Description:
     * Determines if the student is eligible for graduation based on earned
     * credits and volunteer hours. Updates the student's status if they
     * meet the graduation requirements.
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

        if (this.getCreditsEarned() >= Student.MINIMUM_CREDITS - 10 &&
                this.getVolunteerHoursCompleted() >= MINIMUM_VOLUNTEER_HOURS) {
            this.setStatus(new boolean[]{false, false, true}); // Marks student as graduated
        } else {
            throw new IllegalStateException("HPP Student does not meet graduation requirements.");
        }
    }

    /* GETTER(S) */

    /**********************************************************************
     * Method name:
     * getSport
     *
     * Description:
     * Returns the sport the student participates in.
     *
     * Parameters:
     * None
     *
     * Return:
     * The sport the student participates in.
     *********************************************************************/
    public String getSport() {
        return strSport;
    }

    /**********************************************************************
     * Method name:
     * getTeam
     *
     * Description:
     * Returns the team the student is a part of.
     *
     * Parameters:
     * None
     *
     * Return:
     * The team the student is a part of.
     *********************************************************************/
    public String getTeam() {
        return strTeam;
    }

    /**********************************************************************
     * Method name:
     * getPosition
     *
     * Description:
     * Returns the position the student plays in their sport.
     *
     * Parameters:
     * None
     *
     * Return:
     * The position the student plays in their sport.
     *********************************************************************/
    public String getPosition() {
        return strPosition;
    }

    /* SETTER(S) */

    /**********************************************************************
     * Method name:
     * setSport
     *
     * Description:
     * Sets the student's sport.
     *
     * Parameters:
     * strSport The sport the student participates in.
     *
     * Restrictions:
     * Throws IllegalArgumentException if the sport is null or empty.
     *
     * Return:
     * None
     *********************************************************************/
    public void setSport(String strSport) {
        if (strSport == null || strSport.trim().isEmpty()) {
            throw new IllegalArgumentException("Sport cannot be null or empty.");
        }
        this.strSport = strSport;
    }

    /**********************************************************************
     * Method name:
     * setTeam
     *
     * Description:
     * Sets the student's team.
     *
     * Parameters:
     * strTeam The team the student is a part of.
     *
     * Restrictions:
     * Throws IllegalArgumentException if the team is null or empty.
     *
     * Return:
     * None
     *********************************************************************/
    public void setTeam(String strTeam) {
        if (strTeam == null || strTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("Team cannot be null or empty.");
        }
        this.strTeam = strTeam;
    }

    /**********************************************************************
     * Method name:
     * setPosition
     *
     * Description:
     * Sets the student's position in their sport.
     *
     * Parameters:
     * strPosition The position the student plays.
     *
     * Restrictions:
     * Throws IllegalArgumentException if the position is null or empty.
     *
     * Return:
     * None
     *********************************************************************/
    public void setPosition(String strPosition) {
        if (strPosition == null || strPosition.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be null or empty.");
        }
        this.strPosition = strPosition;
    }

} /* End of HPPStudent class */


