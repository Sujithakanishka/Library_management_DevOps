package com.library.servlet.studentservlet;

import java.io.IOException;

import com.library.dao.StudentDao;
import com.library.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Login")
public class StudentLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("StudentLoginservelt Connected");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        StudentDao dao = new StudentDao();

       Student student = dao.login(username, password);

        if(student != null){

            HttpSession session = request.getSession();

            session.setAttribute("studentid", student.getStudentid());

            response.sendRedirect(request.getContextPath()+"/Student/Dashboard.html");

        }
        else{

            response.getWriter().println("<h2>Invalid Username or Password</h2>");

        }
}
}