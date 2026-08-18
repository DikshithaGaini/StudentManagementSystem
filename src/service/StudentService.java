package service;

import java.util.ArrayList;

import model.Student;
import util.FileUtil;

public class StudentService {

    private ArrayList<Student> studentList;

    // Constructor
    public StudentService() {
        studentList = FileUtil.loadStudents();
    }

    // Add Student
    public boolean addStudent(Student student) {

        if (idExists(student.getStudentId())) {
            return false;
        }

        studentList.add(student);
        FileUtil.saveStudents(studentList);

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
    public boolean updateStudent(int studentId,
                                 String studentName,
                                 String department,
                                 int year,
                                 double cgpa) {

        Student student = searchStudent(studentId);

        if (student != null) {

            student.setStudentName(studentName);
            student.setDepartment(department);
            student.setYear(year);
            student.setCgpa(cgpa);

            FileUtil.saveStudents(studentList);

            return true;
        }

        return false;
    }

    // Delete Student
    public boolean deleteStudent(int studentId) {

        Student student = searchStudent(studentId);

        if (student != null) {

            studentList.remove(student);
            FileUtil.saveStudents(studentList);

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
    public int getStudentCount() {
    return studentList.size();
}
public void sortStudentsByCgpa() {

    if (studentList.isEmpty()) {
        System.out.println("No students found.");
        return;
    }

    studentList.sort((s1, s2) ->
            Double.compare(s2.getCgpa(), s1.getCgpa()));

    displayStudents();
}
public void filterByDepartment(String department) {

    boolean found = false;

    for (Student student : studentList) {

        if (student.getDepartment()
                .equalsIgnoreCase(department)) {

            System.out.println(student);
            System.out.println("-------------------------");

            found = true;
        }
    }

    if (!found) {
        System.out.println("No students found.");
    }
}
public void generateReport() {

    if (studentList.isEmpty()) {
        System.out.println("No students found.");
        return;
    }

    int totalStudents = studentList.size();

    double totalCgpa = 0;

    for (Student student : studentList) {
        totalCgpa += student.getCgpa();
    }

    double averageCgpa = totalCgpa / totalStudents;

    System.out.println("\n========== STUDENT REPORT ==========");
    System.out.println("Total Students: " + totalStudents);
    System.out.println("Average CGPA: " + averageCgpa);
}


}