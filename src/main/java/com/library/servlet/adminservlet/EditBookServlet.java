package com.library.servlet.adminservlet;

import java.io.IOException;

import com.library.dao.BookDao;
import com.library.model.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editbook")
public class EditBookServlet extends HttpServlet {

    // Opens Edit Book page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Editbookservelt Connected");

        request.getRequestDispatcher("/Librarian/editbook.jsp")
               .forward(request, response);
    }

    // Handles Search and Update
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Searchbookservelt Connected");

        String action = request.getParameter("action");

        BookDao dao = new BookDao();

        // Search Book
        if ("search".equals(action)) {

            int bookid = Integer.parseInt(request.getParameter("bookid"));

            Book book = dao.searchBookById(bookid);

            if (book != null) {

                request.setAttribute("book", book);

                request.getRequestDispatcher("/Librarian/editbook.jsp")
                       .forward(request, response);

            } else {

                response.getWriter().println("<h2>Book Not Found</h2>");

            }

        }

        // Update Book
        else if ("update".equals(action)) {

            System.out.println("Updatebookservelt Connected");

            int bookid = Integer.parseInt(request.getParameter("bookid"));
            String bookname = request.getParameter("bookname");
            String author = request.getParameter("author");
            String category = request.getParameter("category");
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            Book book = new Book();

            book.setBookid(bookid);
            book.setBookname(bookname);
            book.setAuthor(author);
            book.setCategory(category);
            book.setQuantity(quantity);

            boolean status = dao.updateBook(book);

            if (status) {

                response.sendRedirect(request.getContextPath() + "/viewbook");

            } else {

                response.getWriter().println("<h2>Book Not Updated</h2>");

            }
        }
    }
}