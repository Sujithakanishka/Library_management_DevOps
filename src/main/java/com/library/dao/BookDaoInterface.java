package com.library.dao;

import java.util.List;

import com.library.model.Book;

public interface BookDaoInterface {
    public boolean AddBook(Book book);

    List<Book> getAllBooks();

    public Book searchBookById(int bookid);

    public boolean updateBook(Book book);

    public boolean changeBookStatus(int bookid);

    public Book searchBookByName(String bookname);

}