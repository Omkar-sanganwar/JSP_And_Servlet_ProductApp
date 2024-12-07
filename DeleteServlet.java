package com.tka.product;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete-product")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int pid = Integer.parseInt(request.getParameter("pid"));

        try (Connection conn = DBConnection.getConnection()) {
            String query = "DELETE FROM product WHERE pid=?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, pid);
            ps.executeUpdate();
            response.sendRedirect("display-all");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
