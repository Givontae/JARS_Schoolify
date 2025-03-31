package government.school.staff;

public class Counsellor extends Employee implements StudentManageable {

    /* METHODS IMPLEMENTED BY StudentManageable */

    @Override
    public void setStudentName(Student student, String name) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null.");
        if (name == null || name.trim().isEmpty()) throw new IllegalArgumentException("Name cannot be empty.");

        student.setName(name);
    }

    @Override
    public void setDaysAbsent(Student student, int daysAbsent) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null.");
        if (daysAbsent < 0) throw new IllegalArgumentException("Days absent cannot be negative.");

        student.setDaysAbsent(daysAbsent);
    }

    @Override
    public void setDaysLate(Student student, int daysLate) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null.");
        if (daysLate < 0) throw new IllegalArgumentException("Days late cannot be negative.");

        student.setDaysLate(daysLate);
    }

    @Override
    public void setIsGraduated(Student student, boolean isGraduated) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null.");

        student.setGraduated(isGraduated);
    }

    @Override
    public void setCoopPlacement(SHSMStudent student, String placement) {
        if (student == null) throw new IllegalArgumentException("SHSM Student cannot be null.");
        if (placement == null || placement.trim().isEmpty()) throw new IllegalArgumentException("Placement cannot be empty.");

        student.setCoopPlacement(placement);
    }

    @Override
    public void setHasCompletedCOOP(SHSMStudent student, boolean hasCompleted) {
        if (student == null) throw new IllegalArgumentException("SHSM Student cannot be null.");

        student.setHasCompletedCOOP(hasCompleted);
    }

    @Override
    public void addStudent(Student student, Course course) {
        if (student == null || course == null) throw new IllegalArgumentException("Student and Course cannot be null.");

        course.getStudentsEnrolled().add(student);
    }

    @Override
    public void removeStudent(Student student, Course course) {
        if (student == null || course == null) throw new IllegalArgumentException("Student and Course cannot be null.");

        course.getStudentsEnrolled().remove(student);
    }

    @Override
    public void setCreditsEarned(Student student, int credits) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null.");
        if (credits < 0) throw new IllegalArgumentException("Credits cannot be negative.");

        student.setCreditsEarned(credits);
    }

    /* METHODS IMPLEMENTED BY TimetableActions */

    @Override
    public void addCourse(Student student, Course course) {
        if (student == null || course == null) throw new IllegalArgumentException("Student and Course cannot be null.");

        Course[] timetable = student.getTimetable();
        for (int i = 0; i < timetable.length; i++) {
            if (timetable[i] == null) {
                timetable[i] = course;
                return;
            }
        }
        throw new InvalidTimetableOperationException("No available slots in the timetable.");
    }

    @Override
    public void removeCourse(Student student, Course course) {
        if (student == null || course == null) throw new IllegalArgumentException("Student and Course cannot be null.");

        Course[] timetable = student.getTimetable();
        for (int i = 0; i < timetable.length; i++) {
            if (timetable[i] != null && timetable[i].getCourseCode().equals(course.getCourseCode())) {
                timetable[i] = null;
                return;
            }
        }
        throw new InvalidTimetableOperationException("Course not found in timetable.");
    }

    @Override
    public void removeCourse(Student student, int courseIndex) {
        if (student == null) throw new IllegalArgumentException("Student cannot be null.");

        Course[] timetable = student.getTimetable();
        if (courseIndex < 0 || courseIndex >= timetable.length)
            throw new IndexOutOfBoundsException("Invalid course index.");

        timetable[courseIndex] = null;
    }

    @Override
    public void replaceCourse(Student student, int courseIndex, Course courseAdded) {
        if (student == null || courseAdded == null) throw new IllegalArgumentException("Student and Course cannot be null.");

        Course[] timetable = student.getTimetable();
        if (courseIndex < 0 || courseIndex >= timetable.length)
            throw new IndexOutOfBoundsException("Invalid course index.");

        timetable[courseIndex] = courseAdded;
    }

    @Override
    public void replaceCourse(Student student, Course courseRemoved, Course courseAdded) {
        if (student == null || courseRemoved == null || courseAdded == null)
            throw new IllegalArgumentException("Student and Courses cannot be null.");

        Course[] timetable = student.getTimetable();
        for (int i = 0; i < timetable.length; i++) {
            if (timetable[i] != null && timetable[i].getCourseCode().equals(courseRemoved.getCourseCode())) {
                timetable[i] = courseAdded;
                return;
            }
        }
        throw new InvalidTimetableOperationException("Course to be replaced not found in timetable.");
    }

    @Override
    public void setTimetable(Student student, Timetable timetable) {
        if (student == null || timetable == null) throw new IllegalArgumentException("Student and Timetable cannot be null.");

        student.setTimetable(timetable);
    }

    /*METHODS IMPLEMENTED BY CourseActions*/
    @Override
    public void setCourseGrade(Student student, double grade, Course course) {
        if (student == null || course == null)
            throw new IllegalArgumentException("Student and Course cannot be null.");
        else if (student.isEnrolledInCourse(course)) {
            course.setGrade(student, grade);
        }
    }

    @Override
    public void setCourseCode(Course course, String courseCode) {
        if (course == null)
            throw new IllegalArgumentException("Course cannot be null.");

        course.strCourseCode = courseCode;

    }

    @Override
    public void setCourseTeacher(Course course, String teacherName) {
        if (course == null)
            throw new IllegalArgumentException("Course cannot be null.");
        course.strCourseTeacher = teacherName;

    }

    @Override
    public void setStudentsEnrolled(Course course, ArrayList<Student> students) {
        course.studentsEnrolled = students;

    }
}

