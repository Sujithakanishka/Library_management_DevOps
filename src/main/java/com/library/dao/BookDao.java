package com.library.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;
import com.library.util.DBConnection;

public class BookDao implements BookDaoInterface{
      @Override
      public boolean AddBook(Book book){
        boolean flag=false;
        try{
          Connection con=DBConnection.getConnection();  

          String query = "INSERT INTO Books (bookname,author,category,quantity,bookstatus) VALUES (?, ?, ?, ?,?)";

          PreparedStatement pst =con.prepareStatement(query);

          pst.setString(1,book.getBookname());
          pst.setString(2,book.getAuthor());
          pst.setString(3,book.getCategory());
          pst.setInt(4,book.getQuantity());
          pst.setString(5,"Available");
          int rows = pst.executeUpdate();
          if(rows > 0)
          {
              flag = true;
          }
          pst.close();
          con.close();
        }
        catch(Exception e)
        {
          e.printStackTrace();
        }
        
        return flag;
      }

     @Override
     public List<Book> getAllBooks() {

      List<Book> books = new ArrayList<>();

      try {

          Connection con = DBConnection.getConnection();

          String query = "SELECT * FROM Books";

          PreparedStatement pst = con.prepareStatement(query);

          ResultSet rs = pst.executeQuery();

          while (rs.next()) {

              Book book = new Book();

              book.setBookid(rs.getInt("bookid"));
              book.setBookname(rs.getString("bookname"));
              book.setAuthor(rs.getString("author"));
              book.setCategory(rs.getString("category"));
              book.setQuantity(rs.getInt("quantity"));
              book.setBookstatus(rs.getString("bookstatus"));
            
              books.add(book);
          }

          rs.close();
          pst.close();
          con.close();

      } catch (SQLException ex) {

          ex.printStackTrace();

      }

      return books;
  }

   @Override
   public Book searchBookById(int bookid) {

    Book book = null;

    try {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM Books WHERE bookid = ?";

        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, bookid);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            book = new Book();

            book.setBookid(rs.getInt("bookid"));
            book.setBookname(rs.getString("bookname"));
            book.setAuthor(rs.getString("author"));
            book.setCategory(rs.getString("category"));
            book.setQuantity(rs.getInt("quantity"));
            book.setBookstatus(rs.getString("bookstatus"));
        }

        rs.close();
        pst.close();
        con.close();

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return book;
  }

    @Override
public boolean updateBook(Book book) {

    boolean flag = false;

    try {

        Connection con = DBConnection.getConnection();

        String query = "UPDATE Books SET bookname=?, author=?, category=?, quantity=? WHERE bookid=?";

        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, book.getBookname());
        pst.setString(2, book.getAuthor());
        pst.setString(3, book.getCategory());
        pst.setInt(4, book.getQuantity());
        pst.setInt(5, book.getBookid());

        int rows = pst.executeUpdate();

        if (rows > 0) {
            flag = true;
        }

        pst.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return flag;
}

    @Override
public boolean changeBookStatus(int bookid)
{

    boolean flag=false;

    try
    {

        Connection con=DBConnection.getConnection();

        String currentStatus="";

        String selectQuery=
        "SELECT bookstatus FROM Books WHERE bookid=?";

        PreparedStatement pst1=
        con.prepareStatement(selectQuery);

        pst1.setInt(1,bookid);

        ResultSet rs=pst1.executeQuery();

        if(rs.next())
        {

            currentStatus=rs.getString("bookstatus");

        }

        String newStatus;

        if(currentStatus.equalsIgnoreCase("Available"))
        {

            newStatus="Unavailable";

        }

        else
        {

            newStatus="Available";

        }

        String updateQuery=
        "UPDATE Books SET bookstatus=? WHERE bookid=?";

        PreparedStatement pst2=
        con.prepareStatement(updateQuery);

        pst2.setString(1,newStatus);

        pst2.setInt(2,bookid);

        int rows=pst2.executeUpdate();

        if(rows>0)
        {

            flag=true;

        }

        rs.close();

        pst1.close();

        pst2.close();

        con.close();

    }

    catch(Exception e)
    {

        e.printStackTrace();

    }

    return flag;

}

@Override
public Book searchBookByName(String bookname) {

    Book book = null;

    try {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM Books WHERE bookname = ?";

        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, bookname);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            book = new Book();

            book.setBookid(rs.getInt("bookid"));
            book.setBookname(rs.getString("bookname"));
            book.setAuthor(rs.getString("author"));
            book.setCategory(rs.getString("category"));
            book.setQuantity(rs.getInt("quantity"));
            book.setBookstatus(rs.getString("bookstatus"));
        }

        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return book;
}

}
