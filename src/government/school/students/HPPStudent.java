package government.school.students;

import government.school.Timetable;

/**
 * The HPPStudent class represents a student enrolled in a High-Performance Program (HPP),
 * which includes additional attributes for sports participation such as sport type, team, and position.
 * This class extends the Student class and adds specific logic related to sports involvement.
 */
public class HPPStudent extends Student {

    /* INSTANCE AND CLASS FIELD(S) */
    private String strSport; // The sport the student participates in
    private String strTeam;  // The team the student is a part of
    private String strPosition; // The position the student plays in their sport

    /* CONSTRUCTOR(S) */

    /**
     * Full constructor for HPPStudent.
     *
     * @param intAge            The student's age
     * @param strName           The student's name
     * @param intID             The student's ID number
     * @param password          The student's account password
     * @param intCreditsEarned  The number of credits earned by the student
     * @param intVolunteerHours The number of volunteer hours completed
     * @param dblGPA            The student's grade point average
     * @param intDaysAbsent     The number of days the student was absent
     * @param intDaysLate       The number of days the student was late
     * @param timetable         The student's class timetable
     * @param status            The student's status (e.g., enrolled, graduated, dropped out)
     * @param strSport          The sport the student participates in
     * @param strTeam           The team the student is a part of
     * @param strPosition       The position the student plays in their sport
     */
    public HPPStudent(int intAge, String strName, int intID, String password, int intCreditsEarned, 
                      int intVolunteerHours, double dblGPA, int intDaysAbsent, int intDaysLate, 
                      Timetable timetable, boolean[] status, String strSport, String strTeam, 
                      String strPosition) {
        super(intAge, intID, strName, password, intCreditsEarned, intVolunteerHours, dblGPA, timetable, status);

        setSport(strSport);
        setTeam(strTeam);
        setPosition(strPosition);
    }

    /**
     * Constructor with minimal fields for creating an HPPStudent.
     *
     * @param intAge   The student's age
     * @param strName  The student's name
     * @param strSport The sport the student participates in
     */
    public HPPStudent(int intAge, String strName, String strSport){
        super(intAge, strName);
        setSport(strSport);
    }

    /* LOGIC METHOD(S) */

    /**
     * Determines if the student is eligible for graduation based on earned credits and volunteer hours.
     * Updates the student's status if they meet the graduation requirements.
     *
     * @throws IllegalStateException If the student is not in the right status to graduate or does not meet requirements.
     */
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

    /**
     * @return The sport the student participates in.
     */
    public String getSport() {
        return strSport;
    }

    /**
     * @return The team the student is a part of.
     */
    public String getTeam() {
        return strTeam;
    }

    /**
     * @return The position the student plays in their sport.
     */
    public String getPosition() {
        return strPosition;
    }

    /* SETTER(S) */

    /**
     * Sets the student's sport.
     *
     * @param strSport The sport the student participates in.
     * @throws IllegalArgumentException If the sport is null or empty.
     */
    public void setSport(String strSport) {
        if (strSport == null || strSport.trim().isEmpty()) {
            throw new IllegalArgumentException("Sport cannot be null or empty.");
        }
        this.strSport = strSport;
    }

    /**
     * Sets the student's team.
     *
     * @param strTeam The team the student is a part of.
     * @throws IllegalArgumentException If the team is null or empty.
     */
    public void setTeam(String strTeam) {
        if (strTeam == null || strTeam.trim().isEmpty()) {
            throw new IllegalArgumentException("Team cannot be null or empty.");
        }
        this.strTeam = strTeam;
    }

    /**
     * Sets the student's position in their sport.
     *
     * @param strPosition The position the student plays.
     * @throws IllegalArgumentException If the position is null or empty.
     */
    public void setPosition(String strPosition) {
        if (strPosition == null || strPosition.trim().isEmpty()) {
            throw new IllegalArgumentException("Position cannot be null or empty.");
        }
        this.strPosition = strPosition;
    }
}

