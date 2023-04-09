package peaksoft.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:postgresql://localhost:5432/jdbc_and_hibernate_task";
    private static final String User = "your login";
    private static final String Pass = "your password";

    public static Connection connection (){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, User, Pass);
//            System.out.println("Connected!");
        } catch (SQLException e) {
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
        return connection;
    }
}
