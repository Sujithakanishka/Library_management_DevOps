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

@WebServlet("/issuebook")
public class IssueBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("IssueBookServlet Connected");        
        // Get values from form
        int studentId = Integer.parseInt(request.getParameter("studentid"));
        int bookId = Integer.parseInt(request.getParameter("bookID"));

        Date borrowDate = Date.valueOf(request.getParameter("borrowdate"));
        Date returnDate = Date.valueOf(request.getParameter("returndate"));
        
         
       if (returnDate.before(borrowDate)) {
        response.getWriter().println("Return date cannot be before borrow date.");
        return;
        }

        // Create Borrow object
        Borrow borrow = new Borrow();
        borrow.setStudentid(studentId);
        borrow.setBookid(bookId);
        borrow.setBorrowdate(borrowDate);
        borrow.setReturndate(returnDate);


        borrow.setBookstatus("Borrowed");
        // Call DAO
        BorrowDao dao = new BorrowDao();

       boolean status = dao.IssueBook(borrow);

        if (status) {
            response.sendRedirect(request.getContextPath() +"/Librarian/dashboard.html");
        } else {
            response.getWriter().println("<h2>Unable to Issue Book</h2>");
        }
    }
}