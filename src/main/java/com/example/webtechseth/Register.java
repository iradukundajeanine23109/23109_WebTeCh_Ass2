package com.example.webtechseth;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String gender = request.getParameter("gender");
        String date = request.getParameter("date");
        String address = request.getParameter("address");
        String phone = request.getParameter("number");
        String parent = request.getParameter("parent");
        String email = request.getParameter("gmails");
        String pswd = request.getParameter("pswd");
        String photo = request.getParameter("photo");
        String pdf = request.getParameter("pdf");


        if (fname != null && lname != null && gender != null && date != null && address != null && phone != null && parent != null
                && email != null && pswd != null && photo != null && pdf != null) {

            // Load the MySQL JDBC driver
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                // Handle driver loading error, display a pop-up alert
                String errorMessage = "Database driver not found. Please check your driver configuration.";
                response.setContentType("text/html");
                response.getWriter().println("<script>alert('" + errorMessage + "'); window.location='indexr.jsp';</script>");
                return; // Exit the method to prevent further processing
            }

            String jdbcUrl = "jdbc:mysql://localhost:3306/std";
            String dbUser = "root";
            String dbPassword = "";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser, dbPassword)) {
                // Convert the date string to a java.sql.Date object
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date utilDate;
                try {
                    utilDate = dateFormat.parse(date);
                } catch (ParseException e) {
                    // Handle date parsing error, display a pop-up alert
                    String errorMessage = "Invalid date format. Please enter the date in yyyy-MM-dd format.";
                    response.setContentType("text/html");
                    response.getWriter().println("<script>alert('" + errorMessage + "'); window.location='indexr.jsp';</script>");
                    return; // Exit the method to prevent further processing
                }
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

                String query = "INSERT INTO reg (first_name, last_name, gender, date_of_birth, address, phone, parent, email, password, photo, pdf) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, fname);
                preparedStatement.setString(2, lname);
                preparedStatement.setString(3, gender);
                preparedStatement.setDate(4, sqlDate); // Set the date in the prepared statement
                preparedStatement.setString(5, address);
                preparedStatement.setString(6, phone);
                preparedStatement.setString(7, parent);
                preparedStatement.setString(8, email);
                preparedStatement.setString(9, pswd);
                preparedStatement.setString(10, photo);
                preparedStatement.setString(11, pdf);

                int rowsAffected = preparedStatement.executeUpdate();
                if (rowsAffected > 0) {
                    // Registration successful, redirect to a success page or login page
                    response.sendRedirect("index.jsp");
                } else {
                    // Registration failed, display a pop-up alert
                    String errorMessage = "Registration failed. Please try again.";
                    response.setContentType("text/html");
                    response.getWriter().println("<script>alert('" + errorMessage + "'); window.location='indexr.jsp';</script>");
                }
            }  catch (SQLException e) {
                // Handle database connection or query errors, display a pop-up alert
                String errorMessage = "Database error: " + e.getMessage() + ". Please try again later.";
                response.setContentType("text/html");
                response.getWriter().println("<script>alert('" + errorMessage + "'); window.location='indexr.jsp';</script>");
            }

        } else {
            // Handle missing form fields or invalid input, display a pop-up alert
            String errorMessage = "Invalid input. Please fill in all required fields.";
            response.setContentType("text/html");
            response.getWriter().println("<script>alert('" + errorMessage + "'); window.location='indexr.jsp';</script>");
        }
    }
}
