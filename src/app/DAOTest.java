package app;

import dao.StudentDAO;

public class DAOTest {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        boolean deleted = dao.deleteStudent(999);

        if (deleted) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student not found.");
        }
    }
}