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
                System.out.println("6. Total Students");
                System.out.println("7. Sort Students by CGPA");
                System.out.println("8. Filter Students by Department");
                System.out.println("9. Generate Report");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");

                int choice = sc.nextInt();

                switch (choice) {

                    // Add Student
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

                        if (!service.isValidYear(year)) {
                            System.out.println(
                                    "Invalid year! Year must be between 1 and 4.");
                            break;
                        }

                        System.out.print("Enter CGPA (0-10): ");
                        double cgpa = sc.nextDouble();

                        if (!service.isValidCgpa(cgpa)) {
                            System.out.println(
                                    "Invalid CGPA! CGPA must be between 0 and 10.");
                            break;
                        }

                        Student student = new Student(
                                id,
                                name,
                                department,
                                year,
                                cgpa);

                        boolean added = service.addStudent(student);

                        if (added) {
                            System.out.println("Student Added Successfully.");
                        } else {
                            System.out.println("Student ID already exists.");
                        }

                        break;

                    // Display Students
                    case 2:

                        service.displayStudents();

                        break;

                    // Search Student
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

                    // Update Student
                    case 4:

                        System.out.print("Enter Student ID to Update: ");
                        int updateId = sc.nextInt();

                        Student updateStudent =
                                service.searchStudent(updateId);

                        if (updateStudent == null) {
                            System.out.println("Student Not Found.");
                            break;
                        }

                        sc.nextLine();

                        System.out.print("Enter New Name: ");
                        String newName = sc.nextLine();

                        if (newName.trim().isEmpty()) {
                            System.out.println("Name cannot be empty.");
                            break;
                        }

                        System.out.print("Enter New Department: ");
                        String newDepartment = sc.nextLine();

                        if (newDepartment.trim().isEmpty()) {
                            System.out.println("Department cannot be empty.");
                            break;
                        }

                        System.out.print("Enter New Year (1-4): ");
                        int newYear = sc.nextInt();

                        if (!service.isValidYear(newYear)) {
                            System.out.println(
                                    "Invalid year! Year must be between 1 and 4.");
                            break;
                        }

                        System.out.print("Enter New CGPA (0-10): ");
                        double newCgpa = sc.nextDouble();

                        if (!service.isValidCgpa(newCgpa)) {
                            System.out.println(
                                    "Invalid CGPA! CGPA must be between 0 and 10.");
                            break;
                        }

                        boolean updated = service.updateStudent(
                                updateId,
                                newName,
                                newDepartment,
                                newYear,
                                newCgpa);

                        if (updated) {
                            System.out.println("Student Updated Successfully.");
                        } else {
                            System.out.println("Update Failed.");
                        }

                        break;

                    // Delete Student
                    case 5:

                        System.out.print("Enter Student ID to Delete: ");
                        int deleteId = sc.nextInt();

                        boolean deleted =
                                service.deleteStudent(deleteId);

                        if (deleted) {
                            System.out.println(
                                    "Student Deleted Successfully.");
                        } else {
                            System.out.println("Student Not Found.");
                        }

                        break;

                    // Total Students
                    case 6:

                        System.out.println(
                                "Total Students: "
                                        + service.getStudentCount());

                        break;

                    // Sort Students by CGPA
                    case 7:

                        service.sortStudentsByCgpa();

                        break;

                    // Filter Students by Department
                    case 8:

                        sc.nextLine();

                        System.out.print("Enter Department: ");

                        String dept = sc.nextLine();

                        service.filterByDepartment(dept);

                        break;

                    // Generate Report
                    case 9:

                        service.generateReport();

                        break;

                    // Exit
                    case 10:

                        System.out.println(
                                "Thank You for using Student Management System!");

                        sc.close();

                        return;

                    // Invalid Choice
                    default:

                        System.out.println(
                                "Invalid Choice! Please choose between 1 and 10.");
                }

            } catch (InputMismatchException e) {

                System.out.println(
                        "Invalid Input! Please enter the correct data type.");

                sc.nextLine();
            }
        }
    }
}