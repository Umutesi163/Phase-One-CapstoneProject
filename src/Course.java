import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Course implements Serializable {
    private static final long serialVersionUID = 1L;
    private String code;
    private String title;
    private int credits;
    private List<Student> classList;
    private Instructor instructor; // Track assigned instructor

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.classList = new ArrayList<>();
        this.instructor = null; // No instructor initially
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public List<Student> getClassList() { return classList; }
    public Instructor getInstructor() { return instructor; }

    // Method to assign an instructor to this course
    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

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