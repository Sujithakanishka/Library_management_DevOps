package com.library.servlet.adminservlet;


import java.io.IOException;
import java.util.List;

import com.library.dao.BorrowDao;
import com.library.model.Borrow;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/borrowhistory")
public class BorrowHistoryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Borrowhistoryservelt Connected");

        BorrowDao dao = new BorrowDao();

        List<Borrow> borrow = dao.getBorrowDetails();

        request.setAttribute("borrow", borrow);

        request.getRequestDispatcher("/Librarian/borrowhistory.jsp")
               .forward(request, response);
    }
}