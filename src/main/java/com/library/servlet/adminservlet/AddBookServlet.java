package com.library.servlet.adminservlet;

import java.io.IOException;

import com.library.dao.BookDao;
import com.library.model.Book;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addbook")
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("Addbookservelt Connected");
        String bookname = request.getParameter("bookname").trim();
        String author = request.getParameter("author").trim();
        String category=request.getParameter("category").trim();
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        if (quantity <= 0) {
        response.getWriter().println("Quantity must be greater than 0.");
        return;
        }

        Book book=new Book();
        book.setBookname(bookname);
        book.setAuthor(author);
        book.setCategory(category);
        book.setQuantity(quantity);

        BookDao dao = new BookDao();

        boolean status = dao.AddBook(book);
        if(status)
        {
             response.sendRedirect(request.getContextPath() +"/Librarian/dashboard.html");
        }
        else
        {
            response.getWriter().println("Book not Added");
        }
}
}

