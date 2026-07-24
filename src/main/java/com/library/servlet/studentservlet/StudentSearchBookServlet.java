package com.library.servlet.studentservlet;

import java.io.IOException;

import com.library.dao.BookDao;
import com.library.model.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Searchbook")
public class StudentSearchBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Studentsearchbookservelt Connected");
        request.getRequestDispatcher("/Student/Searchbook.jsp")
               .forward(request, response);
    }

    // Handles Search 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Studentsearchbookbuttonservelt Connected");
        String action = request.getParameter("action");

        BookDao dao = new BookDao();

        // Search Book
        if ("search".equals(action)) {

           String bookname = request.getParameter("bookname");

            Book book = dao.searchBookByName(bookname);

            if(book!=null){

                request.setAttribute("book", book);

            }
            else{

                request.setAttribute("message", "Book Not Found");

            }

            request.getRequestDispatcher("/Student/Searchbook.jsp")
                .forward(request, response);

        }
    }
}