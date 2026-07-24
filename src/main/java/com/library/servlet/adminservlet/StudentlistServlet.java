package com.library.servlet.adminservlet;

import java.io.IOException;
import java.util.List;

import com.library.dao.StudentDao;
import com.library.model.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/students")
public class StudentlistServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Studentslistservelt Connected");

        StudentDao dao = new StudentDao();

       List<Student> students = dao.getAllStudents();
        request.setAttribute("students", students);
        request.getRequestDispatcher("/Librarian/students.jsp")
            .forward(request, response);
    }
}