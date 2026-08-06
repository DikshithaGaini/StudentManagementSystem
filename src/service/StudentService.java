package service;

import java.util.ArrayList;
import model.Student;

public class StudentService {

    private ArrayList<Student> students = new ArrayList<>();

    // Add Student
    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Display All Students
    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
            System.out.println("-------------------------");
        }
    }

    // Search Student by ID
    public Student searchStudent(int studentId) {

        for (Student student : students) {

            if (student.getStudentId() == studentId) {
                return student;
            }

        }

        return null;
    }

    // Update Student
    public boolean updateStudent(int studentId, String name, String department, int year, double cgpa) {

        Student student = searchStudent(studentId);

        if (student != null) {
            student.setStudentName(name);
            student.setDepartment(department);
            student.setYear(year);
            student.setCgpa(cgpa);
            return true;
        }

        return false;
    }
    // Delete Student
public boolean deleteStudent(int studentId) {

    Student student = searchStudent(studentId);

    if (student != null) {
        students.remove(student);
        return true;
    }

    return false;
}
}