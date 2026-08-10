package util;

import java.io.*;
import java.util.ArrayList;

import model.Student;

public class FileUtil {

    private static final String FILE_NAME = "students.dat";

    // Save students to file
    public static void saveStudents(ArrayList<Student> students) {

        try (ObjectOutputStream outputStream =
                     new ObjectOutputStream(
                             new FileOutputStream(FILE_NAME))) {

            outputStream.writeObject(students);

            System.out.println("Student data saved successfully.");

        } catch (IOException e) {

            System.out.println("Error saving student data.");
            e.printStackTrace();
        }
    }

    // Load students from file
    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadStudents() {

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream inputStream =
                     new ObjectInputStream(
                             new FileInputStream(FILE_NAME))) {

            return (ArrayList<Student>) inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error loading student data.");
            return new ArrayList<>();
        }
    }
}