package government.school.staff;
import government.Person;
import java.util.ArrayList;

public class Teacher extends Employee {

    // Fields
    private String strTeachingCertification;
    private ArrayList<Course> subjectsTaught;
    private Timetable timetable;

    // Constructor for Teacher Class
    public Teacher(int intAge, String strName, String[] shiftInterval,
                   int intYearsEmployed, double dblAnnualSalary, boolean[] blnStatus,
                   String strTeachingCertification, ArrayList<Course> subjectsTaught, Timetable
                           timetable){
        super(intAge, strName, shiftInterval, intYearsEmployed, dblAnnualSalary, blnStatus);
        setTeachingCertification(strTeachingCertification);
        setSubjectsTaught(subjectsTaught);
        setTimetable(timetable);
    }

    // Getter Methods

    public String getTeachingCertification(){
        return this.strTeachingCertification;
    }

    public ArrayList<Course> getCoursesTaught(){
        // Cloning the returned object to prevent unintended modification since it is a reference to the original
        return this.coursesTaught.clone();
    }

    public Timetable getTimetable(){
        // Cloning the returned object to prevent unintended modification since it is a reference to the original
        return this.timetable.clone();
    }

    // Setter Methods

    public void setTeachingCertification(String strTeachingCertification){
        if (strTeachingCertification != null && strTeachingCeritifcation.length() > 0){
            this.strTeachingCertification = strTeachingCertification;
        }
    }

    public void setCoursesTaught(ArrayList<Course> coursesTaught){
        if (coursesTaught != null & coursesTaught.size > 0){
            // Cloning the assigned object to prevent unintended modification since it is a reference to the original
            this.coursesTaught = coursesTaught.clone();
        }
    }

    public void setTimetable(Timetable timetable){
        if (timetable != null && timetable.getCourses().length == 4){
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
