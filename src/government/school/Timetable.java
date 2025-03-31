package government.school;

import government.school.students.Student;

import java.sql.Time;
import java.util.Arrays;

public class Timetable {

    private CourseSection[] tt;
    private int MAX_COURSES = 4;

    public CourseSection[] getTt() {
        return this.tt;
    }

    public void removeCourse(Student student, CourseSection course) {
        if (course == null)
            throw new IllegalArgumentException("Course cannot be null");

        int i = isEnrolledInCourse(course);

        if (i == -1) {
            throw new IllegalArgumentException("Student is not enrolled in this course to begin with");
        } else {
            tt[i].removeStudent(student);
            tt[i] = null;
        }
    }



    public void addCourse(Student student, CourseSection course) {
        if (course == null)
            throw new IllegalArgumentException("Course cannot be null");

        int i = isEnrolledInCourse(course);

        if (i != -1) {
            throw new IllegalArgumentException("Student is already enrolled in this course to begin with");
        } else {
            tt[course.getSectionNumber()-1] = course;
            tt[course.getSectionNumber()-1].addStudent(student);
        }

    }

    public void setTimetable(CourseSection[] timetable) {
        if (timetable == null)
            throw new IllegalArgumentException("Timetable cannot be null");

        this.tt = timetable;
    }


    public int isEnrolledInCourse(Course course) {
        if (tt == null) return -1;
        for (int i = 0; i < tt.length; i++) {
            if (this.tt[i].COURSE_CODE.equals(course.COURSE_CODE))
                return ++i;
        }
        return -1;
    }

    @Override
    public Timetable clone() {
        return this.clone();
    }

}
