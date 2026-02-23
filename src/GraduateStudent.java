public class GraduateStudent extends Student {
    private static final double PER_CREDIT_RATE = 800.0;
    private static final double RESEARCH_FEE = 1000.0;

    public GraduateStudent(String name, String email, String studentID, String department) {
        super(name, email, studentID, department);
    }

    public double calculateTuition() {
        int totalCredits = getCourseGrades().keySet().stream().mapToInt(Course::getCredits).sum();
        return totalCredits * PER_CREDIT_RATE + RESEARCH_FEE;
    }
}