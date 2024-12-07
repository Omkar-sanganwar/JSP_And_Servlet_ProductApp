package com.tka.product;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DisplayServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Database connection details
        String url = "jdbc:mysql://localhost:3307/product";
        String username = "root";
        String password = "root";  // Replace with actual DB password

        try {
            // Establish connection
            Connection conn = DriverManager.getConnection(url, username, password);
            
            // Query to fetch all products
            String query = "SELECT * FROM products";
            PreparedStatement pstmt = conn.prepareStatement(query);
            
            // Execute query
            ResultSet rs = pstmt.executeQuery();
            
            // Set ResultSet in request scope for display.jsp
            request.setAttribute("resultSet", rs);
            
            // Forward request to display.jsp to show data
            RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp");
            dispatcher.forward(request, response);
            
            // Close connection
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Database error.");
        }
    }
}
