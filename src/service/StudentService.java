package service;

import java.util.ArrayList;

import dao.StudentDAO;
import model.Student;

public class StudentService {

    private StudentDAO studentDAO;

    public StudentService() {
        studentDAO = new StudentDAO();
    }

    // Add Student
    public boolean addStudent(Student student) {

        if (studentDAO.getStudentById(student.getStudentId()) != null) {
            return false;
        }

        return studentDAO.addStudent(student);
    }

    // Display Students
    public void displayStudents() {

        ArrayList<Student> students =
                studentDAO.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
            System.out.println("-------------------------");
        }
    }

    // Search Student
    public Student searchStudent(int studentId) {

        return studentDAO.getStudentById(studentId);
    }

    // Update Student
    public boolean updateStudent(int studentId,
                                  String studentName,
                                  String department,
                                  int year,
                                  double cgpa) {

        Student student =
                studentDAO.getStudentById(studentId);

        if (student == null) {
            return false;
        }

        student.setStudentName(studentName);
        student.setDepartment(department);
        student.setYear(year);
        student.setCgpa(cgpa);

        return studentDAO.updateStudent(student);
    }

    // Delete Student
    public boolean deleteStudent(int studentId) {

        return studentDAO.deleteStudent(studentId);
    }

    // Check Student ID
    public boolean idExists(int studentId) {

        return studentDAO.getStudentById(studentId) != null;
    }

    // Validate Year
    public boolean isValidYear(int year) {

        return year >= 1 && year <= 4;
    }

    // Validate CGPA
    public boolean isValidCgpa(double cgpa) {

        return cgpa >= 0 && cgpa <= 10;
    }

    // Total Students
    public int getStudentCount() {

        return studentDAO.getStudentCount();
    }

    // Sort Students by CGPA
    public void sortStudentsByCgpa() {

        ArrayList<Student> students =
                studentDAO.getStudentsSortedByCgpa();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
            System.out.println("-------------------------");
        }
    }

    // Filter Students by Department
    public void filterByDepartment(String department) {

        ArrayList<Student> students =
                studentDAO.getStudentsByDepartment(department);

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            System.out.println(student);
            System.out.println("-------------------------");
        }
    }

    // Generate Report
    public void generateReport() {

        studentDAO.generateReport();
    }
}