package com.tka.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/update-product")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int qty = Integer.parseInt(request.getParameter("qty"));
        String category = request.getParameter("category");

        try (Connection conn = DBConnection.getConnection()) {
            String query = "UPDATE product SET name=?, price=?, qty=?, category=? WHERE pid=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, price);
            ps.setInt(3, qty);
            ps.setString(4, category);
            ps.setInt(5, pid);
            ps.executeUpdate();
            response.sendRedirect("display-all");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
