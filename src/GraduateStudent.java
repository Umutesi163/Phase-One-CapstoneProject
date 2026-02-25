import java.io.Serializable;

/**
 * Represents a graduate student in the university system.
 * Inherits from Student and has tuition calculated per credit.
 */
public class GraduateStudent extends Student implements Serializable {

    // Fixed UID for serialization
    private static final long serialVersionUID = 1L;

    private static final double CREDIT_RATE = 1000.0; // Tuition per credit

    /**
     * Default no-arg constructor.
     * Needed for deserialization compatibility.
     */
    public GraduateStudent() {
        super("", "", "", ""); // Initialize with empty/default values
    }

    /**
     * Constructs a new GraduateStudent with given details.
     *
     * @param name       Student's full name
     * @param email      Student's email
     * @param studentID  Unique student ID
     * @param department Academic department
     */
    public GraduateStudent(String name, String email, String studentID, String department) {
        super(name, email, studentID, department);
    }

    /**
     * Calculates tuition based on total enrolled course credits.
     * @return tuition amount
     */
    public double calculateTuition() {
        int totalCredits = getCourseGrades().keySet().stream().mapToInt(Course::getCredits).sum();
        return totalCredits * CREDIT_RATE;
    }
}