import java.util.ArrayList;
import java.util.List;

public class Course {
    private String code;
    private String title;
    private int credits;
    private List<Student> roster;

    public Course(String code, String title, int credits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.roster = new ArrayList<>();
    }

    public String getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public List<Student> getRoster() { return roster; }

    public boolean isFull() { return roster.size() >= 30; }

    public void addStudent(Student student) {
        if (!roster.contains(student)) {
            roster.add(student);
        }
    }

    @Override
    public String toString() {
        return code + " - " + title + " (" + credits + " credits)";
    }
}