package com.library.servlet.adminservlet;

import java.io.IOException;

import com.library.dao.BookDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/changebookstatus")
public class ChangeBookStatusServlet extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Changebookstatusservelt Connected");

        int bookid =
        Integer.parseInt(request.getParameter("bookid"));

        BookDao dao=new BookDao();

        dao.changeBookStatus(bookid);

        response.sendRedirect(
        request.getContextPath()+"/viewbook");

    }

}