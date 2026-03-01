public class GraduateStudent extends Student
{
    private static final double CREDIT_RATE = 1000.0; // Tuition per credit

    public GraduateStudent() {
        super("", "", "", ""); // Initialize with empty/default values
    }

    public GraduateStudent(String name, String email, String studentID, String department) {
        super(name, email, studentID, department);
    }

    public double calculateTuition() {
        int totalCredits = getCourseGrades().keySet().stream().mapToInt(Course::getCredits).sum();
        return totalCredits * CREDIT_RATE;
    }
}