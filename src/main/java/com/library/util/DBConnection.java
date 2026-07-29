package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://mysql:3306/librarymanagementsystem";
    private static final String USER = "libraryuser";
    private static final String PASSWORD = "Library@123";

    public static Connection getConnection() {

    Connection con = null;

    try {

        Class.forName("com.mysql.cj.jdbc.Driver");

        con = DriverManager.getConnection(URL, USER, PASSWORD);

       // System.out.println("Database Connected Successfully!");

    } catch (Exception e) {
        e.printStackTrace();
    }

    return con;
}
}
