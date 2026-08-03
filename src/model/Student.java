package model;

public class Student {

    private int studentId;
    private String studentName;
    private String department;
    private int year;
    private double cgpa;

    // Default Constructor
    public Student() {

    }

    // Parameterized Constructor
    public Student(int studentId, String studentName, String department, int year, double cgpa) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.department = department;
        this.year = year;
        this.cgpa = cgpa;
    }

    // Getters
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDepartment() {
        return department;
    }

    public int getYear() {
        return year;
    }

    public double getCgpa() {
        return cgpa;
    }

    // Setters
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public String toString() {
        return "Student ID : " + studentId +
                "\nName : " + studentName +
                "\nDepartment : " + department +
                "\nYear : " + year +
                "\nCGPA : " + cgpa;
    }
}