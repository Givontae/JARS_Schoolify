package government.school.students;

import government.school.Timetable;

public class SHSMStudent extends Student{

    /* INSTANCE AND CLASS FIELD(S) */
    private String strCOOPPlacement;
    private boolean blnHasCOOPCompleted;

    public SHSMStudent(int intAge, String strName) {

        super(intAge, strName);
        setCOOPPlacement("None");
        setHasCompletedCOOP(false);

    }

    public SHSMStudent(int intAge, int intID, String strName, String password, int intCreditsEarned, int intVolunteerHours, double dblGPA, Timetable timetable, boolean[] status, String strCOOPPlacement, boolean blnHasCOOPCompleted) {

        super(intAge, intID, strName, password, intCreditsEarned, intVolunteerHours, dblGPA, timetable, status);
        setCOOPPlacement(strCOOPPlacement);
        setHasCompletedCOOP(blnHasCOOPCompleted);

    }

    public void setCOOPPlacement(String placement) {
        if (placement == null || placement.trim().isEmpty()) {
            throw new IllegalArgumentException("Student and placement cannot be null or empty.");
        }

        strCOOPPlacement = placement;
    }

    @Override
    public void graduate() {
        if (this.getStatus()[0] || this.getStatus()[1] || this.getStatus()[2]) {
            throw new IllegalStateException("Student is not in the right status to graduate.");
        }

        if (this.getCreditsEarned() >= MINIMUM_CREDITS &&
                this.getVolunteerHoursCompleted() >= MINIMUM_VOLUNTEER_HOURS &&
                this.hasCompletedCOOP()) {
            this.setStatus(new boolean[]{false, false, true});
        } else {
            throw new IllegalStateException("SHSM Student does not meet graduation requirements.");
        }
    }

    public void setHasCompletedCOOP(boolean hasCompleted) {
        if (strCOOPPlacement.equals("None") && hasCompleted)
            throw new IllegalStateException("Set COOP Placement first.");

        this.blnHasCOOPCompleted = hasCompleted;
    }

    public String getCOOPPlacement() {
        return this.strCOOPPlacement;
    }

    public boolean hasCompletedCOOP() {
        return this.blnHasCOOPCompleted;
    }

}