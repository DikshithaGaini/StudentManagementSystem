package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.Student;

public class FileUtil {

    private static final String FILE_NAME = "students.dat";

    // Save students to a file
    public static void saveStudents(ArrayList<Student> students) {

        try {

            ObjectOutputStream output =
                    new ObjectOutputStream(
                            new FileOutputStream(FILE_NAME));

            output.writeObject(students);

            output.close();

            System.out.println("Data saved successfully.");

        } catch (Exception e) {

            System.out.println("Error while saving data.");
        }
    }

    // Load students from a file
    @SuppressWarnings("unchecked")
    public static ArrayList<Student> loadStudents() {

        try {

            File file = new File(FILE_NAME);

            if (!file.exists()) {

                return new ArrayList<>();
            }

            ObjectInputStream input =
                    new ObjectInputStream(
                            new FileInputStream(FILE_NAME));

            ArrayList<Student> students =
                    (ArrayList<Student>) input.readObject();

            input.close();

            return students;

        } catch (Exception e) {

            return new ArrayList<>();
        }
    }
}