package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
}
