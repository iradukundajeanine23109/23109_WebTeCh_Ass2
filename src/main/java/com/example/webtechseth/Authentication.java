package com.example.webtechseth;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.*;

import jakarta.servlet.ServletException;
// Import necessary JDBC classes
import java.sql.*;


@WebServlet("/login")
public class Authentication extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

//        if(email.equalsIgnoreCase("seth@me.com") && password.equals("123")) {
//            HttpSession session = request.getSession();
//            session.setAttribute("email", email);
//            request.getRequestDispatcher("student.jsp").forward(request, response);
//        } else {
//            request.setAttribute("error", "Invalid");
//            request.getRequestDispatcher("index.jsp").forward(request, response);
//        }


// ...

//public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String email = request.getParameter("email");
//        String password = request.getParameter("password");

        // Define your MySQL database connection details
        String jdbcUrl = "jdbc:mysql://localhost:3306/std"; // Replace with your database URL
        String dbUser = "root"; // Replace with your database username
        String dbPassword = ""; // Replace with your database password

        // Initialize database connection objects
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load MySQL JDBC driver

            // Create a database connection
            Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword);

            // Create a SQL query to check if the user exists
            String sql = "SELECT * FROM reg WHERE email = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // User exists, provide access
                HttpSession session = request.getSession();
               session.setAttribute("email", email);
                request.getRequestDispatcher("student.jsp").forward(request, response);
            } else {
                // User does not exist or password is incorrect
                request.setAttribute("error", "Invalid email or password");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }

            // Close the database connection
            resultSet.close();
            preparedStatement.close();
            connection.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Handle any exceptions here
        }
    }
}
