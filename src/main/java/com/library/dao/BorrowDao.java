package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.library.model.Borrow;
import com.library.util.DBConnection;

public class BorrowDao implements BorrowDaoInterface {
     @Override
    public boolean IssueBook(Borrow borrow) {
        System.out.println("Entered IssueBook()");

   if (!studentExists(borrow.getStudentid())) {
    System.out.println("Student NOT Found");
    return false;
}

    if (!bookExists(borrow.getBookid())) {
    System.out.println("Book NOT Found");
    return false;
}

    if (!bookAvailable(borrow.getBookid())) {
    System.out.println("Book Not Available");
    return false;
}

   if (!bookStatusAvailable(borrow.getBookid())){
    System.out.println("Book Not Available");
    return false;
}

   if (!insertBorrow(borrow)) {
    System.out.println("Borrow Insert Failed");
    return false;
}

    // Decrease quantity by 1
    if (!updateBookQuantity(borrow.getBookid())) {
    System.out.println("Quantity Update Failed");
    return false;
}
System.out.println("Book Issued Successfully");
    return true;
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
public boolean ReturnBook(Borrow borrow) {

    boolean flag = false;

    try {

        Connection con = DBConnection.getConnection();

        // Step 1 : Get Book ID using Borrow ID

        String getBookQuery = "SELECT bookid FROM Borrow WHERE borrowid = ? AND bookstatus = 'Borrowed'";

        PreparedStatement pst1 = con.prepareStatement(getBookQuery);

        pst1.setInt(1, borrow.getBorrowid());

        ResultSet rs = pst1.executeQuery();

        int bookId = 0;

        if (rs.next()) {
            bookId = rs.getInt("bookid");
        } else {
            rs.close();
            pst1.close();
            con.close();
            return false;
        }

        rs.close();
        pst1.close();

        // Step 2 : Update Borrow Table

        String updateBorrow =
                "UPDATE Borrow SET bookstatus=?, returndate=? WHERE borrowid=?";

        PreparedStatement pst2 = con.prepareStatement(updateBorrow);

        pst2.setString(1, "Returned");
        pst2.setDate(2, borrow.getReturndate());
        pst2.setInt(3, borrow.getBorrowid());

        int rows1 = pst2.executeUpdate();

        pst2.close();

        if (rows1 == 0) {
            con.close();
            return false;
        }

        // Step 3 : Increase Quantity

        String updateBook =
        "UPDATE Books SET quantity = quantity + 1 WHERE bookid=?";

        PreparedStatement pst3 = con.prepareStatement(updateBook);

        pst3.setInt(1, bookId);

        int rows2 = pst3.executeUpdate();

        pst3.close();

        if (rows2 > 0) {
            flag = true;
        }

        con.close();

    } catch (Exception e) {
        e.printStackTrace();
    }
System.out.println("Book Returned Successfully");
    return flag;
}

@Override
   public List<Borrow> getStudentborrowDetails(int studentid){

      List<Borrow> borrow = new ArrayList<>();

      try {

          Connection con = DBConnection.getConnection();

         String query = "SELECT * FROM Borrow WHERE studentid=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, studentid);

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


     private boolean studentExists( int studentid) {

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

     private boolean bookExists(int bookid) {

        boolean flag = false;

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT * FROM Books WHERE bookid = ?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1,bookid);

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


    private boolean bookAvailable(int bookid) {

        boolean flag = false;

        try {

            Connection con = DBConnection.getConnection();

            String query = "SELECT quantity FROM Books WHERE bookid=?";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, bookid);

            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                int quantity = rs.getInt("quantity");

                if(quantity > 0)
                {
                    flag = true;
                }
            }
            rs.close();
            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

    private boolean bookStatusAvailable(int bookid) {

    boolean flag = false;

    try {

        Connection con = DBConnection.getConnection();

        String query =
        "SELECT bookstatus FROM Books WHERE bookid=?";

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, bookid);

        ResultSet rs = pst.executeQuery();

        if(rs.next()) {

            if(rs.getString("bookstatus")
                    .equalsIgnoreCase("Available")) {

                flag = true;
            }

        }

        rs.close();
        pst.close();
        con.close();

    } catch(Exception e) {
        e.printStackTrace();
    }

    return flag;
}

    private boolean insertBorrow(Borrow borrow) {

        boolean flag = false;

        try {

            Connection con = DBConnection.getConnection();

            String query = "INSERT INTO Borrow(bookid,studentid,borrowdate,returndate,bookstatus) VALUES(?,?,?,?,?) ";

            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,borrow.getBookid());
            pst.setInt(2, borrow.getStudentid());
            pst.setDate(3,borrow.getBorrowdate());
            pst.setDate(4,borrow.getReturndate());
            pst.setString(5, "Borrowed");

            int rows = pst.executeUpdate();

            if (rows>0) {
                flag = true;
            }

            pst.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;
    }

  private boolean updateBookQuantity(int bookid) {

    boolean flag = false;

    try {

        Connection con = DBConnection.getConnection();

        String query =
        "UPDATE Books SET quantity = quantity - 1 WHERE bookid=?";

        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, bookid);

        int rows = pst.executeUpdate();

        if(rows > 0){
            flag = true;
        }

        pst.close();
        con.close();

    } catch(Exception e){
        e.printStackTrace();
    }

    return flag;

}
}