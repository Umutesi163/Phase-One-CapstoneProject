import java.io.*;
import java.util.List;

public class FileManager {

    public static void saveData(List<?> data, String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
            System.out.println("Data saved successfully to " + filename);
        } catch (IOException e) {
            System.out.println("Error saving data to " + filename + ": " + e.getMessage());
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> List<T> loadData(String filename) {
        File file = new File(filename);

        // Check if file exists and has data
        if (!file.exists() || file.length() == 0) {
            System.out.println("No data found in " + filename + ". Starting with empty list.");
            return (List<T>) new java.util.ArrayList<>(); // Return new empty list
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            System.out.println("Loaded data from " + filename);
            return (List<T>) obj;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading data from " + filename + ": " + e.getMessage());
            e.printStackTrace();
            return (List<T>) new java.util.ArrayList<>(); // Return empty list on error
        }
    }
}