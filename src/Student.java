import java.io.Serial;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Represents a student in the university system.
 * Implements Serializable to allow saving/loading from files.
 */
public class Student extends Person implements Serializable {
    // Unique identifier for serialization (required)
    @Serial
    private static final long serialVersionUID = 1L;

    private String studentID;        // Unique ID for the student
    private double GPA;              // Current grade point average
    private String department;       // Academic department (e.g., IT, CS)
    private Map<Course, Double> courseGrades; // Tracks courses and grades<key,value>variable name;

    /**
     * Creates a new student.
     * @param name Student's full name
     * @param email Student's email address
     * @param studentID Unique student ID
     * @param department Academic department
     */
    public Student(String name, String email, String studentID, String department) {
        super(name, email);// calls constructor of super class(person)
        this.studentID = studentID;
        this.department = department;
        this.GPA = 0.0;
        this.courseGrades = new HashMap<>(); // Initialize empty grade map
    }

    // Getters
    public String getStudentID() { return studentID; }
    public double getGPA() { return GPA; }
    public String getDepartment() { return department; }

    /**
     * Returns a copy of the course-grade map.
     * @return map of courses and grades
     */
    public Map<Course, Double> getCourseGrades() { return courseGrades; }//<generic types)

    /**
     * Adds or updates a course grade and recalculates GPA.
     * @param course The course to grade
     * @param grade The grade received (0.0 - 4.0)
     */
    public void addCourseGrade(Course course, double grade)
    //Type → Course (class)

    //Variable name → course (parameter you can use in the method)
    {
        courseGrades.put(course, grade);//adds course and grade to the map(
        calculateGPA();
    }

    /**
     * Recalculates GPA based on all course grades.
     * If no courses, GPA is 0.0.
     */
    private void calculateGPA()
    //This method does not return anything; it only updates the GPA field.
    {
        if (courseGrades.isEmpty()) {
            GPA = 0.0;
            return;
        }
        GPA = courseGrades.values().stream()
                //courseGrades.values() → Gets all the grades from the map.
                // For example, if the student has two courses with grades 3.5 and 4.0, this will give [3.5, 4.0].
                //Think of a Stream like a pipeline that lets you perform operations (like filtering, mapping, or averaging)
                // on a collection in a simple way.
                //Converts each element of the stream to a double primitive.
                .mapToDouble(g -> g)//lambda expression:we’re saying: “Take all grades and treat them as doubles
                .average()
                .orElse(0.0);
    }
    //double sum = 0;
    //for (double g : courseGrades.values()) {
    //    sum += g;
    //}
    //GPA = courseGrades.isEmpty() ? 0.0 : sum / courseGrades.size();
    // without stream we can also use above wildcard mechanism

    /**
     * Returns a summary of the student.
     * @return formatted student info
     */
    @Override
    public String getProfile() {
        return "Student{" + "ID=" + studentID + ", Name=" + getName() + ", GPA=" + GPA + '}';
    }

    /**
     * Compares students by ID (for collections).
     * @param o object to compare
     * @return true if same student
     */
    @Override
    public boolean equals(Object o) {
        //Checks if both references point to the exact same object in memory, then return true
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return studentID.equals(student.studentID);
    }
    /**
     * Returns hash based on student ID.
     * @return hash code
     */
    @Override
    public int hashCode() {
        return studentID.hashCode();
    }
}