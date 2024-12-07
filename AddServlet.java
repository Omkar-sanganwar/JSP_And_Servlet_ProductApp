package com.tka.product;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get input values from the form
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        
        // Database connection details
        String url = "jdbc:mysql://localhost:3307/product";
        String username = "root";
        String password = "root"; // Replace with actual DB password

        try {
            // Establish connection
            Connection conn = DriverManager.getConnection(url, username, password);
            
            // Insert query (without pid if auto-increment is enabled)
            String query = "INSERT INTO products (name, price) VALUES (?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            // Set parameters
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            
            // Execute query
            int result = pstmt.executeUpdate();
            
            if (result > 0) {
                response.sendRedirect("display.jsp");  // Redirect to display page after successful insert
            } else {
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error inserting product.");
            }
            
            // Close connection
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error.");
        }
    }
}
