package service;

import java.util.ArrayList;
import model.Student;

public class StudentService {

    private ArrayList<Student> studentList = new ArrayList<>();

    // Add Student
    public boolean addStudent(Student student) {

        if (idExists(student.getStudentId())) {
            return false;
        }

        studentList.add(student);
        return true;
    }

    // Display All Students
    public void displayStudents() {

        if (studentList.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : studentList) {
            System.out.println(student);
            System.out.println("-------------------------");
        }
    }

    // Search Student by ID
    public Student searchStudent(int studentId) {

        for (Student student : studentList) {

            if (student.getStudentId() == studentId) {
                return student;
            }
        }

        return null;
    }

    // Update Student
    public boolean updateStudent(int studentId, String studentName,
                                 String department, int year, double cgpa) {

        Student student = searchStudent(studentId);

        if (student != null) {

            student.setStudentName(studentName);
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
            studentList.remove(student);
            return true;
        }

        return false;
    }

    // Check if Student ID already exists
    public boolean idExists(int studentId) {
        return searchStudent(studentId) != null;
    }

    // Validate Year
    public boolean isValidYear(int year) {
        return year >= 1 && year <= 4;
    }

    // Validate CGPA
    public boolean isValidCgpa(double cgpa) {
        return cgpa >= 0 && cgpa <= 10;
    }
}