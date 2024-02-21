package com.example.webtechseth;

//import java.sql.Connection;
//        import java.sql.DriverManager;
//        import java.sql.SQLException;
        import java.sql.*;

    public class Database {
        private static final String URL = "jdbc:mysql://localhost:3306/std";
        private static final String USER = "root";
        private static final String PASSWORD = "";

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

