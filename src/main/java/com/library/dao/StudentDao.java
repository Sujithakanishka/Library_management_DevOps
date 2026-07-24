package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;
import com.library.model.Borrow;
import com.library.model.Student;
import com.library.util.DBConnection;

public class StudentDao implements StudentDaoInterface {
    
    @Override
    public boolean signup(Student student )
    {
         boolean flag=false;
        try{
          Connection con=DBConnection.getConnection();  

          String query = "INSERT INTO Students (studentid,username,email,password) VALUES (?, ?, ?, ?)";

          PreparedStatement pst =con.prepareStatement(query);
          pst.setInt(1,student.getStudentid());
          pst.setString(2,student.getUsername());
          pst.setString(3,student.getEmail());
          pst.setString(4,student.getPassword());

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

     public boolean studentExists( int studentid) {

        boolean flag = false;

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM Students WHERE studentid = ?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, studentid);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                flag = true;
            }

            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }
    

   @Override
public Student login(String username, String password) {

    Student student = null;

    try {

        Connection con = DBConnection.getConnection();

        String query = "SELECT * FROM Students WHERE username=? AND password=?";

        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1, username);
        pst.setString(2, password);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {

            student = new Student();

            student.setStudentid(rs.getInt("studentid"));
            student.setUsername(rs.getString("username"));
            student.setPassword(rs.getString("password"));
        }

        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return student;
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
     public List<Borrow> getBorrowDetails() {

      List<Borrow> borrow = new ArrayList<>();

      try {

          Connection con = DBConnection.getConnection();

          String query = "SELECT * FROM Borrow";

          PreparedStatement pst = con.prepareStatement(query);

          ResultSet rs = pst.executeQuery();

          while (rs.next()) {

            Borrow borrows=new Borrow();

            borrows.setBorrowid(rs.getInt("borrowid"));
            borrows.setBookid(rs.getInt("bookid"));
            borrows.setStudentid(rs.getInt("studentid"));
            borrows.setBorrowdate(rs.getDate("borrowdate"));
            borrows.setReturndate(rs.getDate("returndate"));
            borrows.setBookstatus(rs.getString("bookstatus"));
            
            borrow.add(borrows);
          }

          rs.close();
          pst.close();
          con.close();

      } catch (SQLException ex) {

          ex.printStackTrace();

      }

      return borrow;
  }

  
  @Override
public Book searchbook(String bookname) {

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
        }

        rs.close();
        pst.close();
        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }

    return book;
}

@Override
 public List<Student> getAllStudents(){

      List<Student> students = new ArrayList<>();

      try {

          Connection con = DBConnection.getConnection();

          String query = "SELECT studentid,username,email FROM Students";

          PreparedStatement pst = con.prepareStatement(query);

          ResultSet rs = pst.executeQuery();

          while (rs.next()) {

              Student student = new Student();

              student.setStudentid(rs.getInt("studentid"));
              student.setUsername(rs.getString("username"));
              student.setEmail(rs.getString("email"));
              students.add(student);
          }

          rs.close();
          pst.close();
          con.close();

      } catch (SQLException ex) {

          ex.printStackTrace();

      }

      return students;
  }
}
