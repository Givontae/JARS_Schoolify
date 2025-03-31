package government.school.staff;
import government.Person;
import government.school.Course;
import government.school.Timetable;

import java.util.ArrayList;

public class Teacher extends Employee {

    // Fields
    private String strTeachingCertification;
    private ArrayList<Course> subjectsTaught;
    private Timetable timetable;

    // Constructor for Teacher Class
    public Teacher(int intAge, String strName, String strPassword, String strDepartment, String[] shiftInterval,
                   int intYearsEmployed, double dblAnnualSalary, boolean[] blnStatus,
                   String strTeachingCertification, ArrayList<Course> subjectsTaught, Timetable
                           timetable){
        super(intAge, strName, strPassword, strDepartment, shiftInterval, intYearsEmployed, dblAnnualSalary, blnStatus);
        setTeachingCertification(strTeachingCertification);
        setSubjectsTaught(subjectsTaught);
        setTimetable(timetable);
        setDepartment(strDepartment);
    }

    private void setSubjectsTaught(ArrayList<Course> subjectsTaught) {
        if (subjectsTaught == null)
            throw new NullPointerException("subjectsTaught cannot be null");

        this.subjectsTaught = subjectsTaught;
    }

    // Getter Methods

    public String getTeachingCertification(){
        return this.strTeachingCertification;
    }

    public ArrayList<Course> getSubjectsTaught(){
        // Cloning the returned object to prevent unintended modification since it is a reference to the original
        return this.subjectsTaught; /******************************/
    }

    public Timetable getTimetable(){
        // Cloning the returned object to prevent unintended modification since it is a reference to the original
        return this.timetable.clone();
    }

    // Setter Methods

    public void setTeachingCertification(String strTeachingCertification){
        if (strTeachingCertification != null && !strTeachingCertification.isEmpty()){
            this.strTeachingCertification = strTeachingCertification;
        } else
            throw new NullPointerException("strTeachingCertification cannot be null");
    }


    public void setTimetable(Timetable timetable){
        if (timetable != null && timetable.getTt().length == 4){
            // Cloning the assigned object to prevent unintended modification since it is a reference to the original
            this.timetable = timetable.clone();
        }
    }

    // Overridden Methods from the Employee Superclass
    @Override
    public String toString(){
        return "Position: Teacher\n" + super.toString() + "\nTeaching Certification: "
                + strTeachingCertification + "\nSubjects Taught: " + subjectsTaught;
    }
}
