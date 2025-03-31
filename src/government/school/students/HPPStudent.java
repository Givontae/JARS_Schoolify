package government.school.students;

import government.school.Timetable;

public class HPPStudent extends Student {

    /* INSTANCE AND CLASS FIELD(S) */
    private String strSport;
    private String strTeam;
    private String strPosition;

    /* CONSTRUCTOR(S) */
    public HPPStudent(int intAge, String strName, int intID, String password, int intCreditsEarned, int intVolunteerHours, double dblGPA, int intDaysAbsent, int intDaysLate, Timetable timetable, boolean[] status,
                      String strSport, String strTeam, String strPosition) {
        super(intAge, intID, strName, password, intCreditsEarned, intVolunteerHours, dblGPA, timetable, status);

        setSport(strSport);
        setTeam(strTeam);
        setPosition(strPosition);

    }

    public HPPStudent(int intAge, String strName, String strSport){

        super(intAge, strName);
        setSport(strSport);

    }

    /* STORAGE METHODS */

    /* LOGIC METHOD(S) */
    @Override
    public void graduate() {

        if (this.getStatus()[0] || this.getStatus()[1] || this.getStatus()[2]) {
            throw new IllegalStateException("Student is not in the right status to graduate.");
        }

        if (this.getCreditsEarned() >= Student.MINIMUM_CREDITS - 10 &&
                this.getVolunteerHoursCompleted() >= MINIMUM_VOLUNTEER_HOURS) {
            this.setStatus(new boolean[]{false, false, true});
        } else {
            throw new IllegalStateException("HPP Student does not meet graduation requirements.");
        }

    }

    /* GETTER(S) */
    public String getSport() {
        return strSport;
    }

    public String getTeam() {
        return strTeam;
    }

    public String getPosition() {
        return strPosition;
    }

    /* SETTER(S) */
    public void setSport(String strSport) {
        if (strSport == null || strSport.trim().isEmpty())
            throw new IllegalArgumentException("Sport cannot be null or empty.");

        this.strSport = strSport;
    }

    public void setTeam(String strTeam) {
        if (strTeam == null || strTeam.trim().isEmpty())
            throw new IllegalArgumentException("Team cannot be null or empty.");

        this.strTeam = strTeam;
    }

    public void setPosition(String strPosition) {
        if (strPosition == null || strPosition.trim().isEmpty())
            throw new IllegalArgumentException("Position cannot be null or empty.");

        this.strPosition = strPosition;
    }
}
