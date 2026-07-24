package com.library.servlet.adminservlet;

import java.io.IOException;
import java.sql.Date;

import com.library.dao.BorrowDao;
import com.library.model.Borrow;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/return")
public class ReturnBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("ReturnBookServlet Connected");

        int borrowId = Integer.parseInt(request.getParameter("borrowID"));
        Date returnDate = Date.valueOf(request.getParameter("returndate"));

        Borrow borrow = new Borrow();
        borrow.setBorrowid(borrowId);
        borrow.setReturndate(returnDate);

        BorrowDao dao = new BorrowDao();

        boolean status = dao.ReturnBook(borrow);

        if (status) {
             response.sendRedirect(request.getContextPath() + "/borrowhistory");
        } else {
            response.getWriter().println("<h2>Unable to Return Book</h2>");
        }
    }
}