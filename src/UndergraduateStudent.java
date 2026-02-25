import java.io.Serializable;

/**
 * Represents an undergraduate student in the university system.
 * Inherits from Student and has a fixed tuition rate.
 */
public class UndergraduateStudent extends Student implements Serializable {

    // Fixed UID for serialization to avoid InvalidClassException
    private static final long serialVersionUID = 1L;

    private static final double FLAT_TUITION = 5000.0; // Flat tuition for undergraduates

    /**
     * Default no-arg constructor.
     * Needed for deserialization compatibility.
     */
    public UndergraduateStudent() {
        super("", "", "", ""); // Initialize with empty/default values
    }

    /**
     * Constructs a new UndergraduateStudent with given details.
     *
     * @param name       Student's full name
     * @param email      Student's email
     * @param studentID  Unique student ID
     * @param department Academic department
     */
    public UndergraduateStudent(String name, String email, String studentID, String department) {
        super(name, email, studentID, department);
    }

    /**
     * Calculates tuition for undergraduate students.
     * @return flat tuition amount
     */
    public double calculateTuition() {
        return FLAT_TUITION;
    }
}