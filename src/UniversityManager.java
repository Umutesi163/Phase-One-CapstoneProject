import java.util.*;

public class UniversityManager {
    private List<Student> students;
    private List<Course> courses;
    private List<Instructor> instructors; // Track instructors

    public UniversityManager() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.instructors = new ArrayList<>();
    }

    public void registerStudent(Student student) {
        students.add(student);
    }

    public void createCourse(Course course) {
        courses.add(course);
    }

    public void enrollStudentInCourse(Student student, Course course)
            throws CourseFullException, StudentAlreadyEnrolledException {
        if (course.isFull()) {
            throw new CourseFullException("Course " + course.getCode() + " is full.");
        }
        if (course.getClassList().contains(student)) {
            throw new StudentAlreadyEnrolledException("Student already enrolled in " + course.getCode());
        }
        course.addStudent(student);
        student.addCourseGrade(course, 0.0);
    }

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
    }

    public List<Instructor> getInstructors() {
        return instructors;
    }

    public List<Student> getStudentsByDepartment(String dept) {
        return students.stream()
                .filter(s -> s.getDepartment().equalsIgnoreCase(dept))
                .toList();
    }

    public Student getTopStudent() {
        return students.stream()
                .max(Comparator.comparing(Student::getGPA))
                .orElse(null);
    }

    public List<Student> getDeansList() {
        return students.stream()
                .filter(s -> s.getGPA() > 3.5)
                .toList();
    }

    public List<Student> getStudents() { return students; }
    public List<Course> getCourses() { return courses; }
}