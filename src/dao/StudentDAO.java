package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import model.Student;
import util.DatabaseUtil;

public class StudentDAO {

    public boolean addStudent(Student student) {

        String sql = "INSERT INTO students " +
                     "(student_id, student_name, department, year, cgpa) " +
                     "VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement statement =
                     connection.prepareStatement(sql)) {

            statement.setInt(1, student.getStudentId());
            statement.setString(2, student.getStudentName());
            statement.setString(3, student.getDepartment());
            statement.setInt(4, student.getYear());
            statement.setDouble(5, student.getCgpa());

            int rows = statement.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            System.out.println("Error adding student to database.");
            e.printStackTrace();

            return false;
        }
    }
    public ArrayList<Student> getAllStudents() {

    ArrayList<Student> students = new ArrayList<>();

    String sql = "SELECT * FROM students";

    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {

            int id = resultSet.getInt("student_id");
            String name = resultSet.getString("student_name");
            String department = resultSet.getString("department");
            int year = resultSet.getInt("year");
            double cgpa = resultSet.getDouble("cgpa");

            Student student = new Student(
                    id,
                    name,
                    department,
                    year,
                    cgpa
            );

            students.add(student);
        }

    } catch (Exception e) {

        System.out.println("Error retrieving students.");
        e.printStackTrace();
    }

    return students;
}
public Student getStudentById(int studentId) {

    String sql = "SELECT * FROM students WHERE student_id = ?";

    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, studentId);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {

            return new Student(
                    resultSet.getInt("student_id"),
                    resultSet.getString("student_name"),
                    resultSet.getString("department"),
                    resultSet.getInt("year"),
                    resultSet.getDouble("cgpa")
            );
        }

    } catch (Exception e) {

        System.out.println("Error searching student.");
        e.printStackTrace();
    }

    return null;
}
public boolean updateStudent(Student student) {

    String sql = "UPDATE students SET " +
                 "student_name = ?, " +
                 "department = ?, " +
                 "year = ?, " +
                 "cgpa = ? " +
                 "WHERE student_id = ?";

    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, student.getStudentName());
        statement.setString(2, student.getDepartment());
        statement.setInt(3, student.getYear());
        statement.setDouble(4, student.getCgpa());
        statement.setInt(5, student.getStudentId());

        int rows = statement.executeUpdate();

        return rows > 0;

    } catch (Exception e) {

        System.out.println("Error updating student.");
        e.printStackTrace();

        return false;
    }
}
public boolean deleteStudent(int studentId) {

    String sql = "DELETE FROM students WHERE student_id = ?";

    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setInt(1, studentId);

        int rows = statement.executeUpdate();

        return rows > 0;

    } catch (Exception e) {

        System.out.println("Error deleting student.");
        e.printStackTrace();

        return false;
    }
}
public int getStudentCount() {

    String sql = "SELECT COUNT(*) FROM students";

    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        if (resultSet.next()) {
            return resultSet.getInt(1);
        }

    } catch (Exception e) {

        System.out.println("Error counting students.");
        e.printStackTrace();
    }

    return 0;
}
public ArrayList<Student> getStudentsSortedByCgpa() {

    ArrayList<Student> students = new ArrayList<>();

    String sql = "SELECT * FROM students ORDER BY cgpa DESC";

    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql);
         ResultSet resultSet = statement.executeQuery()) {

        while (resultSet.next()) {

            Student student = new Student(
                    resultSet.getInt("student_id"),
                    resultSet.getString("student_name"),
                    resultSet.getString("department"),
                    resultSet.getInt("year"),
                    resultSet.getDouble("cgpa")
            );

            students.add(student);
        }

    } catch (Exception e) {

        System.out.println("Error sorting students.");
        e.printStackTrace();
    }

    return students;
}
public ArrayList<Student> getStudentsByDepartment(String department) {

    ArrayList<Student> students = new ArrayList<>();

    String sql = "SELECT * FROM students WHERE department = ?";

    try (Connection connection = DatabaseUtil.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {

        statement.setString(1, department);

        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {

            Student student = new Student(
                    resultSet.getInt("student_id"),
                    resultSet.getString("student_name"),
                    resultSet.getString("department"),
                    resultSet.getInt("year"),
                    resultSet.getDouble("cgpa")
            );

            students.add(student);
        }

    } catch (Exception e) {

        System.out.println("Error filtering students.");
        e.printStackTrace();
    }

    return students;
}
}
