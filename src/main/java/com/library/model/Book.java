package com.library.model;

public class Book {
    private int bookid;
    private String bookname;
    private String author;
    private String category;
    private int quantity;
    private String bookstatus;


    public Book()
    {

    }


    public Book(int bookid, String bookname, String author, String category, int quantity, String bookstatus) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.author = author;
        this.category = category;
        this.quantity = quantity;
        this.bookstatus=bookstatus;
    }


    public int getBookid() {
        return bookid;
    }
    public String getBookname() {
        return bookname;
    }
    public String getAuthor() {
        return author;
    }
    public String getCategory() {
        return category;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getBookstatus(){
        return bookstatus;
    }


    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
    public void setBookname(String bookname) {
        this.bookname = bookname;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setBookstatus(String bookstatus){
        this.bookstatus=bookstatus;
    }
}
