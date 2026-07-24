package com.library.dao;

import java.util.List;

import com.library.model.Book;
import com.library.model.Borrow;
import com.library.model.Student;
public interface StudentDaoInterface {
    public boolean signup(Student student );
    
    public Student login(String username, String password);

    public boolean studentExists( int studentid);

    List<Book> getAllBooks();

    List<Borrow> getBorrowDetails();

    public Book searchbook(String bookname);

    List<Student> getAllStudents();
}
