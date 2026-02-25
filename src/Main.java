import java.util.*;

public class Main {
    private static UniversityManager um = new UniversityManager();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        loadSavedData();

        while (true) {
            showMenu();
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1 -> registerStudent();
                case 2 -> createCourse();
                case 3 -> enrollStudent();
                case 4 -> viewStudentRecord();
                case 5 -> generateDeansList();
                case 6 -> registerInstructor();
                case 7 -> assignInstructorToCourse();
                case 8 -> {
                    saveData();
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n=== University System ===");
        System.out.println("1. Register Student");
        System.out.println("2. Create Course");
        System.out.println("3. Enroll in Course");
        System.out.println("4. View Student Record");
        System.out.println("5. Generate Dean's List");
        System.out.println("6. Register Instructor");
        System.out.println("7. Assign Instructor to Course");
        System.out.println("8. Save and Exit");
        System.out.print("Choose: ");
    }

    private static void registerStudent() {
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("ID: "); String id = sc.nextLine();
        System.out.print("Department: "); String dept = sc.nextLine();
        System.out.print("Type (undergrad/grad): "); String type = sc.nextLine();

        Student s = type.equals("grad") ?
                new GraduateStudent(name, email, id, dept) :
                new UndergraduateStudent(name, email, id, dept);

        um.registerStudent(s);
        System.out.println("Student registered.");
    }

    private static void createCourse() {
        System.out.print("Code: "); String code = sc.nextLine();
        System.out.print("Title: "); String title = sc.nextLine();
        System.out.print("Credits: "); int credits = sc.nextInt(); sc.nextLine();
        um.createCourse(new Course(code, title, credits));
        System.out.println("Course created.");
    }

    private static void enrollStudent() {
        System.out.print("Student ID: "); String id = sc.nextLine();
        System.out.print("Course Code: "); String code = sc.nextLine();

        Student student = um.getStudents().stream().filter(s -> s.getStudentID().equals(id)).findFirst().orElse(null);
        Course course = um.getCourses().stream().filter(c -> c.getCode().equals(code)).findFirst().orElse(null);

        if (student == null || course == null) {
            System.out.println("Invalid student or course.");
            return;
        }

        try {
            um.enrollStudentInCourse(student, course);
            System.out.println("Enrolled successfully.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void viewStudentRecord() {
        System.out.print("Student ID: "); String id = sc.nextLine();
        Student s = um.getStudents().stream().filter(st -> st.getStudentID().equals(id)).findFirst().orElse(null);
        if (s == null) {
            System.out.println("Not found.");
            return;
        }
        System.out.println(s.getProfile());
        s.getCourseGrades().forEach((c, g) -> System.out.println(c + " - Grade: " + g));
    }

    private static void generateDeansList() {
        System.out.println("\n=== Dean's List (GPA > 3.5) ===");
        um.getDeansList().forEach(s -> System.out.println(s.getProfile()));
    }

    private static void registerInstructor() {
        System.out.print("Name: "); String name = sc.nextLine();
        System.out.print("Email: "); String email = sc.nextLine();
        System.out.print("Department: "); String dept = sc.nextLine();
        System.out.print("Office Number: "); String office = sc.nextLine();
        Instructor instructor = new Instructor(name, email, dept, office);
        um.addInstructor(instructor);
        System.out.println("Instructor registered.");
    }

    private static void assignInstructorToCourse() {
        System.out.print("Instructor Email: "); String email = sc.nextLine();
        System.out.print("Course Code: "); String code = sc.nextLine();
        Instructor instructor = um.getInstructors().stream()
                .filter(i -> i.getEmail().equals(email))
                .findFirst().orElse(null);
        Course course = um.getCourses().stream()
                .filter(c -> c.getCode().equals(code))
                .findFirst().orElse(null);
        if (instructor == null || course == null) {
            System.out.println("Invalid instructor or course.");
            return;
        }
        course.setInstructor(instructor);
        System.out.println("Instructor assigned to course.");
    }

    private static void loadSavedData() {
        List<Student> students = FileManager.loadData("students.dat");
        List<Course> courses = FileManager.loadData("courses.dat");

        if (students != null) um.getStudents().addAll(students);
        if (courses != null) um.getCourses().addAll(courses);
    }

    private static void saveData() {
        FileManager.saveData(um.getStudents(), "students.dat");
        FileManager.saveData(um.getCourses(), "courses.dat");
    }
}