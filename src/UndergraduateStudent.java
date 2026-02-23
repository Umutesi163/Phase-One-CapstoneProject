public class UndergraduateStudent extends Student {
    private static final double FLAT_TUITION = 5000.0;

    public UndergraduateStudent(String name, String email, String studentID, String department) {
        super(name, email, studentID, department);
    }

    public double calculateTuition() {
        return FLAT_TUITION;
    }
}