package government.school.students;

import government.Person;
import government.school.Course;
import government.school.CourseSection;
import government.school.Timetable;
import government.school.util.Auth;

import java.io.*;
import java.util.ArrayList;

public class Student extends Person implements Serializable {

    /* INSTANCE AND CLASS FIELD(S) */
    private final int STUDENT_ID;
    private String PASSWORD;

    private int intCreditsEarned;
    private int intVolunteerHoursCompleted;
    private boolean[] status;
    private double dblGPA;
    private Timetable timetable;

    private static final int MAX_COURSES = 4;
    public static final int MINIMUM_CREDITS = 30;
    public static final int MINIMUM_VOLUNTEER_HOURS = 40;
    private static ArrayList<Student> students = new ArrayList<>();

    /* CONSTRUCTORS */
    public Student(int intAge, String strName) {
        super(intAge, strName);
        this.STUDENT_ID = Auth.generateID();
        setPassword(Auth.generatePassword(8));

        this.intCreditsEarned = 0;
        this.intVolunteerHoursCompleted = 0;
        this.dblGPA = 0.0;
        this.timetable = new Timetable();
        this.status = new boolean[]{false, false, false};

        students.add(this);

    }

    public Student(int intAge, int intID, String strName, String password, int intCreditsEarned, int intVolunteerHours, double dblGPA, Timetable timetable, boolean[] status) {

        super(intAge, strName);
        this.STUDENT_ID = Auth.generateID();
        setPassword(password);

        this.intCreditsEarned = intCreditsEarned;
        this.intVolunteerHoursCompleted = intVolunteerHours;
        this.dblGPA = dblGPA;
        this.timetable = timetable;
        this.status = status;

        students.add(this);
    }


    /* SETTERS */
    public void setPassword(String password) {
        if (password == null || password.trim().length() < 8)
            throw new IllegalArgumentException("Password cannot be null or less than 8 characters");
        this.PASSWORD = password;
    }

    public void setVolunteerHours(int intVolunteerHours) {
        if (intVolunteerHours < 0)
            throw new IllegalArgumentException("Volunteer hours cannot be negative");
        this.intVolunteerHoursCompleted = intVolunteerHours;
    }


    public void setTimetable(Timetable timetable) {
        this.timetable = timetable.clone();
    }

    public void setStatus(boolean[] status) {
        this.status = status.clone();
    }


    /* GETTERS */
    public static int getCount() {
        return students.size();
    }

    public int getID() {
        return this.STUDENT_ID;
    }

    public int getCreditsEarned() {
        return this.intCreditsEarned;
    }

    public double getGPA() {
        return this.dblGPA;
    }

    public Timetable getTimetable() {
        return this.timetable.clone();
    }

    public boolean[] getStatus() {
        return this.status.clone();
    }

    public int getVolunteerHoursCompleted(){
        return this.intVolunteerHoursCompleted;
    }

    /* LOGIC METHODS */ //suspended, vacation, graduated
    public void graduate() {

        if (this.getStatus()[0] || this.getStatus()[1] || this.getStatus()[2]) {
            throw new IllegalStateException("Student is not in the right status to graduate.");
        }

        if (this.getCreditsEarned() >= Student.MINIMUM_CREDITS &&
                this.getVolunteerHoursCompleted() >= MINIMUM_VOLUNTEER_HOURS) {
            this.setStatus(new boolean[]{false, true});
        } else {
            throw new IllegalStateException("Student does not meet graduation requirements.");
        }

    }



    /* STORAGE METHODS */
    public static void saveStudentsToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Student records have been saved.");
        } catch (IOException e) {
            System.out.println("Error saving student records");
        }
    }

    public static void loadStudentsFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("No student records found.");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            ArrayList<Student> loadedStudents = (ArrayList<Student>) ois.readObject();
            students.addAll(loadedStudents);
            System.out.println("Student records have been loaded.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading student records");
        }
    }

    @Override
    public String toString(){
        return "";
    }

}