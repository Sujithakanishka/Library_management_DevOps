package com.library.servlet.studentservlet;

import java.io.IOException;

import com.library.dao.StudentDao;
import com.library.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Signup")
public class StudentSignupServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Signupervelt Connected");

        int studentid = Integer.parseInt(request.getParameter("studentid"));
        String username = request.getParameter("username").trim();
        String email = request.getParameter("email").trim();
        String password=request.getParameter("password").trim();
        

        if (studentid <= 0) {
        response.getWriter().println("Enter Correct Student ID");
        return;
        }

        Student student=new Student();
        student.setStudentid(studentid);
        student.setUsername(username);
        student.setEmail(email);
        student.setPassword(password);

        StudentDao dao = new StudentDao();

        if (dao.studentExists(studentid)) {
            response.getWriter().println("Student already has an account. Please Sign In.");
            return;
        }

        boolean status = dao.signup(student);
        
        if(status)
        {
            response.sendRedirect(request.getContextPath() +"/Student/Dashboard.html");
        }
        else
        {
            response.getWriter().println("Can't Signup");
        }
}
}

