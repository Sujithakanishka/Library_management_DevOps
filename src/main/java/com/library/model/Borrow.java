package com.library.model;

import java.sql.Date;

public class Borrow {
    private int borrowid;
    private int bookid;
    private int studentid;
    private Date borrowdate;
    private Date returndate;
    private String bookstatus;

    public Borrow()
    {

    }

    
    public Borrow(int borrowid, int bookid, int studentid, Date borrowdate, Date returndate, String bookstatus) {
        this.borrowid = borrowid;
        this.bookid = bookid;
        this.studentid = studentid;
        this.borrowdate = borrowdate;
        this.returndate = returndate;
        this.bookstatus=bookstatus;
    }


    public int getBorrowid() {
        return borrowid;
    }

    public int getBookid() {
        return bookid;
    }

    public int getStudentid() {
        return studentid;
    }

    public Date getBorrowdate() {
        return borrowdate;
    }

    public Date getReturndate() {
        return returndate;
    }
    
    public String getBookstatus() {
        return bookstatus;
    }



    public void setBorrowid(int borrowid) {
        this.borrowid = borrowid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public void setBorrowdate(Date borrowdate) {
        this.borrowdate = borrowdate;
    }

    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }

    public void setBookstatus(String bookstatus) {
        this.bookstatus = bookstatus;
    }

    
}
