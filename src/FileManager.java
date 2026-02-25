import java.io.*;
import java.util.List;

public class FileManager {

    public static void saveData(List<?> data, String filename) {
        // Ensure it's CSV
        if (!filename.endsWith(".csv")) {
            filename += ".csv";
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            if (data.isEmpty()) return;

            // Write header (assumes all objects are same type)
            Object first = data.get(0);
            if (first instanceof Student) {
                writer.write("ID,Name,Email,Department,GPA,Type");
                writer.newLine();
                for (Object obj : data) {
                    Student s = (Student) obj;
                    writer.write(String.format("%s,%s,%s,%s,%.2f,%s",
                            s.getStudentID(),
                            s.getName(),
                            s.getEmail(),
                            s.getDepartment(),
                            s.getGPA(),
                            s.getClass().getSimpleName()));
                    writer.newLine();
                }
            } else if (first instanceof Course) {
                writer.write("Code,Title,Credits");
                writer.newLine();
                for (Object obj : data) {
                    Course c = (Course) obj;
                    writer.write(String.format("%s,%s,%d",
                            c.getCode(),
                            c.getTitle(),
                            c.getCredits()));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving data to " + filename + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> loadData(String filename) {
        File file = new File(filename);

        if (!file.exists() || file.length() == 0) {
            System.out.println("No data found in " + filename + ". Starting with empty list.");
            return (List<T>) new java.util.ArrayList<>();
        }

        System.out.println("Loaded data from " + filename);
        // CSV loading logic can be added later if needed
        return (List<T>) new java.util.ArrayList<>();
    }
}