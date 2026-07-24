package com.library.servlet.studentservlet;


import java.io.IOException;
import java.util.List;

import com.library.dao.BorrowDao;
import com.library.model.Borrow;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Studentborrowhistory")
public class StudentBorrowHistoryServlet extends HttpServlet {

   @Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

    System.out.println("Studentborrowhistoryservelt Connected");
    HttpSession session = request.getSession();

    Integer studentId = (Integer) session.getAttribute("studentid");

    if (studentId == null) {
        response.sendRedirect(request.getContextPath() + "/Studentlogin.html");
        return;
    }

    BorrowDao dao = new BorrowDao();

    List<Borrow> borrow = dao.getStudentborrowDetails(studentId);

    request.setAttribute("borrow", borrow);

    request.getRequestDispatcher("/Student/Studentborrowhistory.jsp")
           .forward(request, response);
}
}