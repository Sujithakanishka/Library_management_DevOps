package com.library.servlet.studentservlet;

import java.io.IOException;
import java.util.List;

import com.library.model.Book;
import com.library.dao.BookDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Viewbook")
public class StudentViewBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Studentviewbookservelt Connected");

        BookDao dao = new BookDao();

        List<Book> books = dao.getAllBooks();

        request.setAttribute("books", books);

        request.getRequestDispatcher("/Student/Viewbook.jsp")
               .forward(request, response);
    }
}