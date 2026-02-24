import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L; // Required for serialization
    private String code;
    private String title;
    private int credits;
    private List<Student> classList;

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.classList = new ArrayList<>();
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public List<Student> getClassList() { return classList; }
    public boolean isFull() { return classList.size() >= 30; }

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