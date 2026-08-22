package app;

import java.sql.Connection;
import util.DatabaseUtil;

public class DatabaseTest {

    public static void main(String[] args) {

        try {

            Connection connection = DatabaseUtil.getConnection();

            System.out.println("Database connected successfully!");

            connection.close();

        } catch (Exception e) {

            System.out.println("Database connection failed.");
            e.printStackTrace();
        }
    }
}
