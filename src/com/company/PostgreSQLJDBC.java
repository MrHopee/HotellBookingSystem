package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
//a class for making the connection
public class PostgreSQLJDBC {
    private static Connection conn;

    private PostgreSQLJDBC() {
    }

    public static Connection getConnection() throws SQLException {
        // TODO Exception handle et
        if (conn == null || conn.isClosed()) {
            String url = "jdbc:postgresql://localhost:5432/hotel_booking";
            Properties props = new Properties();
            props.setProperty("user", "postgres");
            props.setProperty("password", "umut123");
            conn = DriverManager.getConnection(url, props);
        }
        return conn;
    }
}
