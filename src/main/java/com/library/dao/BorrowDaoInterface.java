package com.library.dao;

import java.util.List;


import com.library.model.Borrow;

public interface BorrowDaoInterface {

   public boolean IssueBook(Borrow borrow);

   List<Borrow> getBorrowDetails();

   public boolean ReturnBook(Borrow borrow );

   List<Borrow> getStudentborrowDetails(int studentid);
}