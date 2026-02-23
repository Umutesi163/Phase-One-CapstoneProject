import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Student extends Person implements Serializable {
    private String studentID;
    private double GPA;
    private String department;
    private Map<Course, Double> courseGrades;

    public Student(String name, String email, String studentID, String department) {
        super(name, email);
        this.studentID = studentID;
        this.department = department;
        this.GPA = 0.0;
        this.courseGrades = new HashMap<>();
    }

    public String getStudentID() { return studentID; }
    public double getGPA() { return GPA; }
    public String getDepartment() { return department; }

    public Map<Course, Double> getCourseGrades() { return courseGrades; }

    public void addCourseGrade(Course course, double grade) {
        courseGrades.put(course, grade);
        calculateGPA();
    }

    private void calculateGPA() {
        if (courseGrades.isEmpty()) {
            GPA = 0.0;
            return;
        }
        GPA = courseGrades.values().stream().mapToDouble(g -> g).average().orElse(0.0);
    }

    @Override
    public String getProfile() {
        return "Student{" + "ID=" + studentID + ", Name=" + getName() + ", GPA=" + GPA + '}';
    }
}
