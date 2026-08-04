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

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Exit");
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
                    System.out.println("Thank you for using the Student Management System. Goodbye!");
                    break;

                default:

                    System.out.println("Invalid Choice!");

            }

        } while (choice != 4);

        sc.close();

    }

}