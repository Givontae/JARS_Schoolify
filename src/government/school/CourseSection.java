package government.school;

import government.school.staff.Teacher;
import government.school.students.Student;
import government.school.util.ArrayMap;

import java.util.ArrayList;
import java.util.HashMap;

public class CourseSection extends Course {

    private int intSectionNumber;
    private Teacher courseTeacher;
    private ArrayMap<Integer,Double> grades;
    private ArrayMap<Integer,Integer> absences;
    private ArrayMap<Integer,Integer> lates;
    private ArrayList<Student> studentsEnrolled;

    public static ArrayList<CourseSection> courseSections = new ArrayList<CourseSection>();


    public CourseSection(String strCourseCode, int dblCourseGrade, int intCourseMaxCapacity, int intCourseMinCapacity, int intCourseSection, Teacher courseTeacher) {

        super(strCourseCode, dblCourseGrade, intCourseMaxCapacity, intCourseMinCapacity);
        setSectionNumber(intCourseSection);
        setCourseTeacher(courseTeacher);

        grades = new ArrayMap<Integer,Double>();
        absences = new ArrayMap<Integer,Integer>();
        lates = new ArrayMap<Integer,Integer>();
        studentsEnrolled = new ArrayList<Student>();

        courseSections.add(this);


    }

    public void endCourse() {

    }

    public void finishCourse() {

    }

    public int getSectionNumber() {
        return intSectionNumber;
    }

    public void setGrade(Student student, double grade) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");

        if (grade < 0 || grade > 100)
            throw new IllegalArgumentException("Grade must be between 0 and 100 inclusive");

        if (!grades.containsKey(student.getID()))
            throw new IllegalArgumentException("No such student exists in this course section");

        grades.put(student.getID(), grade);
    }

    public void setAbsences(Student student, int absence) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");

        if (absence < 0)
            throw new IllegalArgumentException("Absences must be between 0 and X inclusive");

        if (!absences.containsKey(student.getID()))
            throw new IllegalArgumentException("No such student exists in this course section");

        absences.put(student.getID(), absence);

    }

    public void setLates(Student student, int late) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");

        if (late < 0)
            throw new IllegalArgumentException("Lates must be between 0 and X inclusive");

        if (!lates.containsKey(student.getID()))
            throw new IllegalArgumentException("No such student exists in this course section");

        lates.put(student.getID(), late);

    }

    // Getter for grades
    public double getGrade(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");

        if (!grades.containsKey(student.getID()))
            throw new IllegalArgumentException("No grade found for the student in this course section");

        return grades.get(student.getID());
    }

    // Getter for absences
    public int getAbsences(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");

        if (!absences.containsKey(student.getID()))
            throw new IllegalArgumentException("No absence record found for the student in this course section");

        return absences.get(student.getID());
    }

    // Getter for lates
    public int getLates(Student student) {
        if (student == null)
            throw new IllegalArgumentException("Student cannot be null");

        if (!lates.containsKey(student.getID()))
            throw new IllegalArgumentException("No late record found for the student in this course section");

        return lates.get(student.getID());
    }

    public void setSectionNumber(int intSectionNumber) {
        if (intSectionNumber < 1 || intSectionNumber > 4)
            throw new IllegalArgumentException("Section number out of range");

        this.intSectionNumber = intSectionNumber;
    }

    public void setCourseTeacher(Teacher courseTeacher) {
        if (courseTeacher == null)
            throw new IllegalArgumentException("Course teacher cannot be null");

        this.courseTeacher = courseTeacher;
    }

    // Method to add a student (Ensures MAX capacity)
    public boolean addStudent(Student newStudent) {
        if (newStudent == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (studentsEnrolled.size() >= COURSE_MAX_CAPACITY) {
            throw new InvalidTimetableOperationException("Course is full. Cannot add more students.");
        }
        studentsEnrolled.add(newStudent);
        return true; // Student added successfully
    }

    // Method to remove a student (Ensures MIN capacity)
    public boolean removeStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null");
        }
        if (studentsEnrolled.size() <= COURSE_MIN_CAPACITY) {
            throw new IllegalStateException("Cannot remove student. Below minimum capacity.");
        }
        return studentsEnrolled.remove(student);
    }

}
