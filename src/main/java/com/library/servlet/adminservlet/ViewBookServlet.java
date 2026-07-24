package com.library.servlet.adminservlet;

import java.io.IOException;
import java.util.List;

import com.library.dao.BookDao;
import com.library.model.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/viewbook")
public class ViewBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Viewbookservelt Connected");

        BookDao dao = new BookDao();

        List<Book> books = dao.getAllBooks();

        request.setAttribute("books", books);

        request.getRequestDispatcher("/Librarian/viewbook.jsp")
               .forward(request, response);
    }
}