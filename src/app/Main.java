package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import model.Student;
import service.StudentService;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        while (true) {

            try {

                System.out.println("\n========== STUDENT MANAGEMENT SYSTEM ==========");
                System.out.println("1. Add Student");
                System.out.println("2. Display Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    case 1:

                        System.out.print("Enter Student ID: ");
                        int id = sc.nextInt();

                        if (id <= 0) {
                            System.out.println("Student ID must be positive.");
                            break;
                        }

                        if (service.idExists(id)) {
                            System.out.println("Student ID already exists.");
                            break;
                        }

                        sc.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = sc.nextLine();

                        if (name.trim().isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter Department: ");
                        String department = sc.nextLine();

                        if (department.trim().isEmpty()) {
                            System.out.println("Department cannot be empty.");
                            break;
                        }

                        System.out.print("Enter Year (1-4): ");
                        int year = sc.nextInt();

                        if (year < 1 || year > 4) {
                            System.out.println("Invalid Year.");
                            break;
                        }

                        System.out.print("Enter CGPA (0-10): ");
                        double cgpa = sc.nextDouble();

                        if (cgpa < 0 || cgpa > 10) {
                            System.out.println("Invalid CGPA.");
                            break;
                        }

                        Student student = new Student(id, name, department, year, cgpa);
                        service.addStudent(student);

                        System.out.println("Student Added Successfully.");
                        break;

                    case 2:

                        service.displayStudents();
                        break;

                    case 3:

                        System.out.print("Enter Student ID: ");
                        int searchId = sc.nextInt();

                        Student found = service.searchStudent(searchId);

                        if (found != null) {
                            System.out.println("\nStudent Found:");
                            System.out.println(found);
                        } else {
                            System.out.println("Student Not Found.");
                        }

                        break;

                    case 4:

                        System.out.print("Enter Student ID to Update: ");
                        int updateId = sc.nextInt();

                        Student updateStudent = service.searchStudent(updateId);

                        if (updateStudent == null) {
                            System.out.println("Student Not Found.");
                            break;
                        }

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        System.out.print("Enter New Department: ");
                        String newDepartment = sc.nextLine();

                        System.out.print("Enter New Year: ");
                        int newYear = sc.nextInt();

                        System.out.print("Enter New CGPA: ");
                        double newCgpa = sc.nextDouble();

                        boolean updated = service.updateStudent(updateId, newName, newDepartment, newYear, newCgpa);

                        if (updated) {
                            System.out.println("Student Updated Successfully.");
                        } else {
                            System.out.println("Update Failed.");
                        }

                        break;

                    case 5:

                        System.out.print("Enter Student ID to Delete: ");
                        int deleteId = sc.nextInt();

                        boolean deleted = service.deleteStudent(deleteId);

                        if (deleted) {
                            System.out.println("Student Deleted Successfully.");
                        } else {
                            System.out.println("Student Not Found.");
                        }

                        break;

                    case 6:

                        System.out.println("Thank You!");
                        sc.close();
                        System.exit(0);

                    default:

                        System.out.println("Invalid Choice.");

                }

            } catch (InputMismatchException e) {

                System.out.println("Invalid Input! Please enter the correct data type.");
                sc.nextLine();

            }

        }

    }

}