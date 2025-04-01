package government.school;

import government.school.students.Student;

import java.sql.Time;
import java.util.Arrays;

/**
 * The Timetable class manages a student's schedule, allowing for the addition
 * and removal of courses. It ensures that students do not exceed the maximum
 * course limit and maintains a record of enrolled courses.
 */
public class Timetable {

    /* INSTANCE AND CLASS FIELD(S) */
    private CourseSection[] tt; // Array representing the student's enrolled courses
    private int MAX_COURSES = 4; // Maximum number of courses a student can take

    /* GETTER(S) */

    /**
     * Retrieves the student's current timetable.
     *
     * @return The array of enrolled CourseSection objects.
     */
    public CourseSection[] getTt() {
        return this.tt;
    }

    /* LOGIC METHOD(S) */

    /**
     * Removes a course from the student's timetable.
     *
     * @param student The student removing the course.
     * @param course  The course section to be removed.
     * @throws IllegalArgumentException If the course is null or the student is not enrolled.
     */
    public void removeCourse(Student student, CourseSection course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }

        int i = isEnrolledInCourse(course);

        if (i == -1) {
            throw new IllegalArgumentException("Student is not enrolled in this course to begin with");
        } else {
            tt[i].removeStudent(student);
            tt[i] = null;
        }
    }

    /**
     * Adds a course to the student's timetable.
     *
     * @param student The student enrolling in the course.
     * @param course  The course section to be added.
     * @throws IllegalArgumentException If the course is null or already enrolled.
     */
    public void addCourse(Student student, CourseSection course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null");
        }

        int i = isEnrolledInCourse(course);

        if (i != -1) {
            throw new IllegalArgumentException("Student is already enrolled in this course to begin with");
        } else {
            tt[course.getSectionNumber() - 1] = course;
            tt[course.getSectionNumber() - 1].addStudent(student);
        }
    }

    /**
     * Sets the student's timetable with a new array of courses.
     *
     * @param timetable The new timetable to be assigned.
     * @throws IllegalArgumentException If the provided timetable is null.
     */
    public void setTimetable(CourseSection[] timetable) {
        if (timetable == null) {
            throw new IllegalArgumentException("Timetable cannot be null");
        }
        this.tt = timetable;
    }

    /**
     * Checks if a student is enrolled in a specific course.
     *
     * @param course The course to check enrollment for.
     * @return The index of the course in the timetable if enrolled, otherwise -1.
     */
    public int isEnrolledInCourse(Course course) {
        if (tt == null) return -1;
        for (int i = 0; i < tt.length; i++) {
            if (this.tt[i].COURSE_CODE.equals(course.COURSE_CODE)) {
                return ++i;
            }
        }
        return -1;
    }

    /**
     * Creates and returns a copy of this Timetable instance.
     *
     * @return A cloned Timetable object.
     */
    @Override
    public Timetable clone() {
        return this.clone();
    }
}
