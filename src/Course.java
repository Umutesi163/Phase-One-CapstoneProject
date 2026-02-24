import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String title;
    private int credits;
    private List<Student> classList;  // ← Simple name: "classList" instead of "roster"

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.classList = new ArrayList<>();  // Start with an empty class list
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }

    // Return the list of students in this class
    public List<Student> getClassList() { return classList; }

    // Check if the class is full (30 students max)
    public boolean isFull() { return classList.size() >= 30; }

    // Add a student to the class if they're not already in it
    public void addStudent(Student student) {
        if (!classList.contains(student)) {
            classList.add(student);
        }
    }

    @Override
    public String toString() {
        return code + " - " + title + " (" + credits + " credits)";
    }
}