package com.library.servlet.adminservlet;


import java.io.IOException;

import com.library.dao.AdminDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Loginservelt Connected");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        AdminDao dao = new AdminDao();

        boolean status = dao.login(username, password);
        if(status)
        {
            response.sendRedirect(request.getContextPath() + "/Librarian/dashboard.html");
        }
        else
        {
            response.getWriter().println("<h2>Invalid Username or Password</h2>");
        }
}
}