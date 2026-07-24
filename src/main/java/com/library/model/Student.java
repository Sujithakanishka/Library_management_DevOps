package com.library.model;

public class Student {
    private int studentid;
    private String username;
    private String email;
    private String password;

    public Student()
    {
        
    }


    public Student(int studentid, String username, String email, String password) {
        this.studentid = studentid;
        this.username = username;
        this.email = email;
        this.password = password;
    }


    public int getStudentid() {
        return studentid;
    }
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    
}
