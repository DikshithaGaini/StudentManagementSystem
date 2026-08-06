package app;

import java.util.Scanner;
import model.Student;
import service.StudentService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        int choice;

        do {

            System.out.println("===== Student Management System =====");
System.out.println("1. Add Student");
System.out.println("2. View Students");
System.out.println("3. Search Student");
System.out.println("4. Update Student");
System.out.println("5. Delete Student");
System.out.println("6. Exit");
System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    System.out.print("Enter Year: ");
                    int year = sc.nextInt();

                    System.out.print("Enter CGPA: ");
                    double cgpa = sc.nextDouble();

                    Student student = new Student(id, name, department, year, cgpa);

                    service.addStudent(student);

                    break;

                case 2:

                    service.displayStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID to search: ");
                    int searchId = sc.nextInt();

                    Student foundStudent = service.searchStudent(searchId);

                    if (foundStudent != null) {
                        System.out.println("\nStudent Found");
                        System.out.println(foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Student Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Department: ");
                    String newDepartment = sc.nextLine();

                    System.out.print("Enter New Year: ");
                    int newYear = sc.nextInt();

                    System.out.print("Enter New CGPA: ");
                    double newCgpa = sc.nextDouble();

                    boolean updated = service.updateStudent(updateId, newName, newDepartment, newYear, newCgpa);

                    if (updated) {
                        System.out.println("Student updated successfully!");
                    } else {
                        System.out.println("Student not found!");
                    }

                    break;
                    case 5:

    System.out.print("Enter Student ID to delete: ");
    int deleteId = sc.nextInt();

    boolean deleted = service.deleteStudent(deleteId);

    if (deleted) {
        System.out.println("Student deleted successfully!");
    } else {
        System.out.println("Student not found!");
    }

    break;

                case 6:

                    System.out.println("Thank you for using the Student Management System. Goodbye!");

                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 6);

        sc.close();
    }
}